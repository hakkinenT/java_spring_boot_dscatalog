package com.hakkinenT.dscatalog.services;

import com.hakkinenT.dscatalog.dto.*;
import com.hakkinenT.dscatalog.entities.PasswordRecover;
import com.hakkinenT.dscatalog.entities.Role;
import com.hakkinenT.dscatalog.entities.User;
import com.hakkinenT.dscatalog.projections.UserDetailsProjection;
import com.hakkinenT.dscatalog.repositories.PasswordRecoverRepository;
import com.hakkinenT.dscatalog.repositories.RoleRepository;
import com.hakkinenT.dscatalog.repositories.UserRepository;
import com.hakkinenT.dscatalog.services.exceptions.DatabaseException;
import com.hakkinenT.dscatalog.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class AuthService {
    @Value(value = "${email.password-recover.token.minutes}")
    private Long tokenMinutes;

    @Value(value = "${email.password-recover.uri}")
    private String recoverUri;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordRecoverRepository passwordRecoverRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public void createRecoverToken(EmailDTO body) {
        User user = userRepository.findByEmail(body.getEmail());
        if(user == null){
            throw new ResourceNotFoundException("Email não encontrado");
        }

        String token = UUID.randomUUID().toString();

        PasswordRecover entity = new PasswordRecover();
        entity.setEmail(body.getEmail());
        entity.setToken(token);
        entity.setExpiration(Instant.now().plusSeconds(tokenMinutes * 60));
        entity = passwordRecoverRepository.save(entity);

        String text = "Acesse o link para definir uma nova senha\n\n"
                + recoverUri + token + ". Validade de " + tokenMinutes + " minutos";

        emailService.sendEmail(body.getEmail(), "Recuperação de senha",text);
    }

    @Transactional
    public void saveNewPassword(NewPasswordDTO body) {
        List<PasswordRecover> result = passwordRecoverRepository.searchValidTokens(body.getToken(), Instant.now());
        if (result.isEmpty()){
            throw new ResourceNotFoundException("Token inválido.");
        }

        User user = userRepository.findByEmail(result.get(0).getEmail());
        user.setPassword(passwordEncoder.encode(body.getPassword()));

        user = userRepository.save(user);
    }
}

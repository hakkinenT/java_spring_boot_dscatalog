package com.hakkinenT.dscatalog.services.validation;

import com.hakkinenT.dscatalog.controllers.exceptions.FieldMessage;
import com.hakkinenT.dscatalog.dto.UserInsertDTO;
import com.hakkinenT.dscatalog.entities.User;
import com.hakkinenT.dscatalog.repositories.UserRepository;
import jakarta.validation.ConstraintValidator;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UserInsertValidator implements ConstraintValidator<UserInsertValid, UserInsertDTO> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void initialize(UserInsertValid ann) {
    }

    @Override
    public boolean isValid(UserInsertDTO dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        User user = userRepository.findByEmail(dto.getEmail());
        if(user != null){
            list.add(new FieldMessage("email", "Esse email já existe!"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}

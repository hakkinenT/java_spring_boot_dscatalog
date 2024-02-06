package com.hakkinenT.dscatalog.controllers;

import com.hakkinenT.dscatalog.dto.UserDTO;
import com.hakkinenT.dscatalog.dto.UserInsertDTO;
import com.hakkinenT.dscatalog.dto.UserUpdateDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import com.hakkinenT.dscatalog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable){
        Page<UserDTO> users = userService.findAll(pageable);
        return ResponseEntity.ok().body(users);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        UserDTO user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PreAuthorize("hasAnyRole('ROLE_OPERATOR','ROLE_ADMIN')")
    @GetMapping(value = "/me")
    public ResponseEntity<UserDTO> findByMe(){
        UserDTO user = userService.findByMe();
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@Valid @RequestBody UserInsertDTO dto){
        UserDTO newdto = userService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newdto.getId()).toUri();
        return ResponseEntity.created(uri).body(newdto);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @Valid @RequestBody UserUpdateDTO dto){
        UserDTO user = userService.update(id, dto);
        return ResponseEntity.ok().body(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

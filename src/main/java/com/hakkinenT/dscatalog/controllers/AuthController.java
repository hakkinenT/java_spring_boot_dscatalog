package com.hakkinenT.dscatalog.controllers;

import com.hakkinenT.dscatalog.dto.*;
import com.hakkinenT.dscatalog.services.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
@Tag(name = "Authentication", description = "Controller for Authentication")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Operation(
            description = "Create a recover token",
            summary = "Create a recover token",
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204"),
                    @ApiResponse(description = "Bad Request", responseCode = "400"),
                    @ApiResponse(description = "Not Found", responseCode = "404"),
                    @ApiResponse(description = "Unprocessable Entity", responseCode = "422")
            }
    )
    @PostMapping(value = "/recover-token", produces = "application/json")
    public ResponseEntity<Void> createRecoverToken(@Valid @RequestBody EmailDTO body){
        authService.createRecoverToken(body);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            description = "Save a new user password",
            summary = "Save a new user password",
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204"),
                    @ApiResponse(description = "Not Found", responseCode = "404"),
                    @ApiResponse(description = "Unprocessable Entity", responseCode = "422")
            }
    )
    @PutMapping(value = "/new-password", produces = "application/json")
    public ResponseEntity<Void> saveNewPassword(@Valid @RequestBody NewPasswordDTO body){
        authService.saveNewPassword(body);
        return ResponseEntity.noContent().build();
    }
}

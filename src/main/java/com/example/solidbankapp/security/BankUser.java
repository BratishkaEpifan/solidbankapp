package com.example.solidbankapp.security;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EntityScan
public class BankUser {

    @Id
    @Column("login")
    private String login;

    @Column("password")
    private String password;

    @Column("role")
    private String role;

}
package com.example.solidbankapp.security;

import com.example.solidbankapp.database.BankUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final BankUserRepository bankUserRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveUser(BankUser bankUser) {
        bankUser.setRole("ROLE_USER");
        bankUser.setPassword(passwordEncoder.encode(bankUser.getPassword()));
        bankUserRepository.register(bankUser.getLogin(), bankUser.getPassword(), bankUser.getRole());
    }

    public BankUser findByLogin(String login) {
        return bankUserRepository.findByLogin(login);
    }

    public BankUser findByLoginAndPassword(String login, String password) {
        BankUser bankUser = bankUserRepository.findByLogin(login);
        if (bankUser != null) {
            if (passwordEncoder.matches(password, bankUser.getPassword())) {
                return bankUser;
            }
        }
        return null;
    }

}

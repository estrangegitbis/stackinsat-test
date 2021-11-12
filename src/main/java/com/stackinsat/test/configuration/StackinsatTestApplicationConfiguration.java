package com.stackinsat.test.configuration;

import com.stackinsat.test.model.Account;
import com.stackinsat.test.model.AppUser;
import com.stackinsat.test.model.AppUserRole;
import com.stackinsat.test.repository.AccountRepository;
import com.stackinsat.test.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@Configuration
public class StackinsatTestApplicationConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Bean
    CommandLineRunner initDatabase(AccountRepository accountRepository,
                                   UserService userService) {
        return args -> {
            AppUser admin = new AppUser();
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setEmail("admin@email.com");
            admin.setBirthDate(LocalDate.of(2010, 01, 01));
            admin.setAppUserRoles(new ArrayList<AppUserRole>(Arrays.asList(AppUserRole.ROLE_ADMIN)));

            userService.signup(admin);

            AppUser client1 = new AppUser();
            client1.setUsername("client1");
            client1.setPassword("client1");
            client1.setEmail("client1@email.com");
            client1.setBirthDate(LocalDate.of(1950, 01, 01));
            client1.setAppUserRoles(new ArrayList<AppUserRole>(Arrays.asList(AppUserRole.ROLE_CLIENT)));

            userService.signup(client1);

            AppUser client2 = new AppUser();
            client2.setUsername("client2");
            client2.setPassword("client2");
            client2.setEmail("client2@email.com");
            client2.setBirthDate(LocalDate.of(1915, 01, 01));
            client2.setAppUserRoles(new ArrayList<AppUserRole>(Arrays.asList(AppUserRole.ROLE_CLIENT)));

            userService.signup(client2);

            Account account1 = new Account();
            account1.setNumber("001");
            account1.setAmount(101f);
            account1.setUser(client1);
            accountRepository.save(account1);

            Account account2 = new Account();
            account2.setNumber("002");
            account2.setAmount(102f);
            account2.setUser(client1);
            accountRepository.save(account2);

            Account account3 = new Account();
            account3.setNumber("003");
            account3.setAmount(103f);
            account3.setUser(client2);
            accountRepository.save(account3);

            Account account4 = new Account();
            account4.setNumber("004");
            account4.setAmount(104f);
            account4.setUser(client2);
            accountRepository.save(account4);

            Account account5 = new Account();
            account5.setNumber("005");
            account5.setAmount(105f);
            account5.setUser(client2);
            accountRepository.save(account5);
        };
    }
}

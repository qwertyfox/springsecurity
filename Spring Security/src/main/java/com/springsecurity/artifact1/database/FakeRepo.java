package com.springsecurity.artifact1.database;

import com.google.common.collect.Lists;
import com.springsecurity.artifact1.users.AppUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.springsecurity.artifact1.security.AppUserRoles.*;


@Repository("fake")
public class FakeRepo implements AppUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeRepo(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public List<AppUsers> loadApplicationUsers () {
         List<AppUsers> appUsersList = Lists.newArrayList(
                new AppUsers("Peter",
                        passwordEncoder.encode("peter"),
                        STUDENTS.getSimpleGrantedAuthorities(),
                        true,true,true,true),
                new AppUsers("Bob",
                        passwordEncoder.encode("Tony"),
                        ADMIN.getSimpleGrantedAuthorities(),
                        true,true,true, true),
                new AppUsers("Steve",
                        passwordEncoder.encode("Steve"),
                        TRAINEE_ADMIN.getSimpleGrantedAuthorities(),
                        true,true,true,true)
        );
         return appUsersList;
    }

    @Override
    public Optional<AppUsers> selectUserByUsername(String username) {
        return loadApplicationUsers().stream()
                .filter(appUsers -> username.equals(appUsers.getUsername()))
                .findFirst();

    }
}

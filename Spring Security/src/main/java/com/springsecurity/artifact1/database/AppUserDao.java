package com.springsecurity.artifact1.database;

import com.springsecurity.artifact1.users.AppUsers;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AppUserDao {

    Optional<AppUsers> selectUserByUsername(String username);




}

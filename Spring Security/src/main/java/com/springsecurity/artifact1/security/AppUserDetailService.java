package com.springsecurity.artifact1.security;

import com.springsecurity.artifact1.database.AppUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailService implements UserDetailsService {

    private final AppUserDao appUserDao;

    @Autowired
    public AppUserDetailService(@Qualifier("fake") AppUserDao appUserDao) {
        this.appUserDao = appUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserDao.selectUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User "+ username+ "not found."));
    }
}

package com.springsecurity.artifact1.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.springsecurity.artifact1.security.AppUserPermissions.*;


public enum AppUserRoles {

    STUDENTS(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ,
                            COURSE_WRITE,
                            STUDENT_READ,
                            STUDENT_WRITE)),
    TRAINEE_ADMIN(Sets.newHashSet(COURSE_READ,
                                    STUDENT_READ));

    public final Set<AppUserPermissions> appUserPermissions;


    AppUserRoles(Set<AppUserPermissions> appUserPermissions) {
        this.appUserPermissions = appUserPermissions;
    }

    //added code for authorities
    public Set<SimpleGrantedAuthority> getSimpleGrantedAuthorities() {
        Set<SimpleGrantedAuthority> authorisedPermissions = getAppUserPermissions()
                .stream()
                .map(p -> new SimpleGrantedAuthority(p.getPermissions()))
                .collect(Collectors.toSet());

        // most important step from the documentation
        authorisedPermissions.add(new SimpleGrantedAuthority("ROLE_" +this.name()));
        return authorisedPermissions;
    }

    public Set<AppUserPermissions> getAppUserPermissions() {
        return appUserPermissions;
    }
}

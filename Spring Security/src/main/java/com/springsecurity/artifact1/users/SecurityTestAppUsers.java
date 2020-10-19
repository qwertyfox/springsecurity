//package com.springsecurity.artifact1.users;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//
//public class SecurityTestAppUsers implements UserDetails {
//
//
//    private final Set<? extends GrantedAuthority> grantedAuthorities;
//    private final String password;
//    private final String username;
//    // Disabled for the test
////    private final boolean isAccountNonExpired;
////    private final boolean isAccountNonLocked;
////    private final boolean isCredentialsNonExpired;
////    private final boolean isEnabled;
//
//
//    public SecurityTestAppUsers(Set<? extends GrantedAuthority> grantedAuthorities, String password, String username) {
//        this.grantedAuthorities = grantedAuthorities;
//        this.password = password;
//        this.username = username;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return null;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return false;
//    }
//}

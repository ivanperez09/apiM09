package com.example.apiprueba.modelo.entidades;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Entity
@Data
@RequiredArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Long id; //identificador autonumèric
    @Column(unique = true)
    private String username; //no es repeteix username
    private String password;
    private String avatar;
    private String rol = "USER"; //per defecte

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        //l'altre rol seria "ROLE_ADMIN", per exemple
        return roles;
    }

    public Long getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getRol() {
        return rol;
    }

    @Override
    public String getPassword() {
        return null;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

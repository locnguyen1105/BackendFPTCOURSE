package com.example.demo.security.Service;

import com.example.demo.Model.Roles;
import com.example.demo.Model.Students;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Id;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class StudentDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private String last_name;
    private String image;
    private String username;
    @JsonIgnore
    private String password;
    private String first_name;
    @Id
    private String code;
    private Date birth_date;

    private Collection<? extends GrantedAuthority> authorities;

    public static StudentDetails build(Students student) {
        List<GrantedAuthority> authorities = student.getUserRolesByCode().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRolesByRoleId().getName()))
                .collect(Collectors.toList());
        return new StudentDetails(student.getLast_name(), student.getImage(), student.getUsername(), student.getPassword(), student.getFirst_name(), student.getCode(), student.getBirth_date(), authorities);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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

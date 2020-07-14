package com.example.demo.Repository;

import com.example.demo.Model.Students;
import com.example.demo.Model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.security.auth.Subject;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Students, String> {
    Students findByCode(String code);

    Students findByUsernameAndPassword(String username, String password);

    Students findByUsername(String username);

}

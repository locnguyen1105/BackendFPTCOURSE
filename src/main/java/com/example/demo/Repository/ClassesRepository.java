package com.example.demo.Repository;

import com.example.demo.Model.Classes;
import com.example.demo.Model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, String> {
    List<Classes> findByCode(String code);
}

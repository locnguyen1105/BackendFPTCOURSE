package com.example.demo.Repository;

import com.example.demo.Model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface DashBoardRepository extends JpaRepository<Subjects, String> {
    @Query(value = "select Subjects.* from ClassSubs\n" +
            "inner join Subjects on Subjects.code = ClassSubs.subject_code\n" +
            "inner join ClassSubStudents on ClassSubs.code = ClassSubStudents.classsub_code\n" +
            "where ClassSubStudents.student_code = ?1", nativeQuery = true)
    List<Subjects> findSubjectByStudent(String code);
}

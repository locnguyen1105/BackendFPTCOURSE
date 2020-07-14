package com.example.demo.Repository;

import com.example.demo.Model.Subjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubjectRepository extends JpaRepository<Subjects, String> {
    @Query(value = "select * from subjects where subjects.code = ?1", nativeQuery = true)
    Subjects findAll(String code);

    @Query(value = "select Subjects.* from ClassSubs\n" +
            "inner join Subjects on Subjects.code = ClassSubs.subject_code\n" +
            "inner join ClassSubStudents on ClassSubs.code = ClassSubStudents.classsub_code\n" +
            "where ClassSubStudents.student_code = ?1", nativeQuery = true)
    List<Subjects> findSubjectByStudent(String code);
}

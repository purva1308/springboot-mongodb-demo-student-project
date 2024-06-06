package com.student.app.repository;


import com.student.app.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    public List<Student> getStudentsAbove90InMaths() {
        var query = new Query(Criteria.where("mathsScore").gt(90)
                .and("division").gte(1).lte(10));
        return mongoTemplate.find(query, Student.class);
    }

    public void insertStudent(Student student) {
        mongoTemplate.insert(student,"studentDetails");
    }


}

package com.vk.demojdbc.repository;

import com.vk.demojdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired

    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s) {
        String sql = "insert into student (rollNo,name,marks) values(?,?,?)";
        int result = jdbc.update(sql,s.getRollNo(),s.getName(),s.getMarks());
        System.out.println(result);
    }

    public List<Student> findAll() {
        String sql = "select * from student";
        return  jdbc.query(sql,(ResultSet rs, int rowNum) -> {
            Student s = new Student();
            s.setRollNo(rs.getInt("rollNo"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));
            return s;
        });
    }
}

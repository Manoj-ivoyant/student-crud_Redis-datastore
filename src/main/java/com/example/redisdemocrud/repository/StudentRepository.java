package com.example.redisdemocrud.repository;

import com.example.redisdemocrud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    public static final String HASH_KEY = "Student";
    @Autowired
    private RedisTemplate redisTemplate;

    public Student save(Student student) {
        redisTemplate.opsForHash().put(HASH_KEY, student.getId(), student);
        return student;
    }

    public List<Student> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Student findStudentById(int id) {
        return (Student) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    public String deleteById(int id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "student deleted successfully";
    }

    public Student updateById(Student student, int id) {
        redisTemplate.opsForHash().put(HASH_KEY, id, student);
        return student;
    }

    public List<Student> findAllByMarksGreater(float mark) {
        return findAll().stream().filter(i->i.getMarks()>mark).toList();
    }
}

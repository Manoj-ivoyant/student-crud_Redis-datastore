package com.example.redisdemocrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Student")
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Float marks;
}

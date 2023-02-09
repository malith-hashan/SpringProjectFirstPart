package com.example.springBootProject.Modles;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Student {
    @Id
    private String id;
    private String name;
    private String dateOfBirth;
    private double average;
}

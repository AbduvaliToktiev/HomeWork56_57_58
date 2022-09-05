package com.example.homework56_57_58.model;

import com.example.homework56_57_58.enums.StatusTask;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
public class Task {
    private Integer id;
    private String header;
    private String description;
    private Date publicationDate;
    private Integer userId;
    private StatusTask statusTask;
}

package com.restToDoList.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Task {
    private int taskid;
    private String task;
    private int priority;
    private String status;
}

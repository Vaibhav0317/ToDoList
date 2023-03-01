package com.restToDoList.entity;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class task {
    private int taskid;
    private String task;
    private int priority;
    private String status;
}

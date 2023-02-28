package com.restToDoList.controller;

import com.restToDoList.entity.task;
import com.restToDoList.service.taskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class homeControllar {

    @Autowired
    private taskService taskservice;
@GetMapping("/getall")
    public List<task> getAllList()
    {
        return this.taskservice.getalltask();
    }

    @GetMapping("/priority/{id}")
    public task getPriority(@PathVariable("id") int Pid)
    {
        return this.taskservice.getTaskByPriority(Pid);
    }

    @PostMapping("/add")
    public task addTask(@RequestBody task t)
    {
        task Task=this.taskservice.addTask(t);
        return Task;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable("id") int Pid)
    {
        this.taskservice.deleteTask(Pid);
        System.out.println("delete task successfully");
    }
    @DeleteMapping("/deleteall")
    public void deleteAll()
    {
       this.taskservice.deleteall();
        System.out.println("delete all task successfully");

    }


}

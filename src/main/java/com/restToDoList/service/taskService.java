package com.restToDoList.service;

import com.restToDoList.entity.task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class taskService {
    //create list of task
   static private List<task> list=new ArrayList<task>();

    static {
        list.add(new task("creating api project",1,"inprogress"));
        list.add(new task("Learning springboot",2,"almost completed"));
    }


    public List<task> getalltask()
    {
        return list;
    }

    public task getTaskByPriority(int priority)
    {
        task t=null;
        t=list.stream().filter(e->e.getPriority()==priority).findFirst().get();
        return t;
    }

    public task addTask(task t)
    {
        list.add(t);
        return t;
    }

    public void deleteTask(int id)
    {
       list= list.stream().filter(task -> task.getPriority()!=id).collect(Collectors.toList());
    }


    public void deleteall()
    {
        list.clear();
    }


}

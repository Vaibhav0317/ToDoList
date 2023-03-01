package com.restToDoList.service;

import com.restToDoList.entity.task;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class taskService {
    //create list of task
   static private List<task> list=new ArrayList<task>();
   private task t;



    static {
        list.add(new task(1,"Learning springboot",1,"Inprogress"));
        list.add(new task(2,"Learning mongo",3,"pending"));
    }


    public List<task> getalltask()
    {
        return list;
    }

    public task getTaskById(int id)
    {
        task t=null;
        t=list.stream().filter(e->e.getTaskid()==id).findFirst().get();
        return t;
    }

    public task addTask(task t)
    {
        list.add(t);
        return t;
    }

    public void deleteTask(int id)
    {
       list= list.stream().filter(task -> task.getTaskid()!=id).collect(Collectors.toList());



        //System.out.println("list after delete>==="+list);
    }


    public void deleteall()
    {
        list.clear();
    }


}

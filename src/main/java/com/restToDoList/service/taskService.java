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
        try {
            t = list.stream().filter(e -> e.getTaskid() == id).findFirst().get();
        }catch (Exception e){
         e.printStackTrace();
        }
        return t;
    }

    public boolean addTask(task t)
    {
        boolean isPresent=isContains(t.getTaskid());
       // System.out.println("list flag >=="+isPresent);
        if(isPresent==false) {
       //     System.out.println("list element add >=="+t);
            list.add(t);
        }
        return isPresent;
    }

    public boolean deleteTask(int id)
    {
        boolean isPresent=isContains(id);
        System.out.println("delete id "+isPresent);
        if(isPresent==true) {
            list = list.stream().filter(task -> task.getTaskid() != id).collect(Collectors.toList());
        }
        //System.out.println("list after delete>==="+list);
        return isPresent;
    }


    public void deleteall()
    {
        list.clear();
    }


    public int update(task t,int id)
    {
        int i=0;
        boolean isPresent=isContains(id);
        if(isPresent==true)
        {
            boolean Temp=isContains(t.getTaskid());
            if (t.getTaskid()==id) {
            i=1;
            System.out.println("task update with same id");
            list= list.stream().map(e->{
                if(e.getTaskid()==id)
                {
                    e.setTask(t.getTask());
                    e.setPriority(t.getPriority());
                    e.setStatus(t.getStatus());
                }
                return e;
            }).collect(Collectors.toList());
        }
            else if(Temp==true)
            {
                System.out.println("task is already present please use different task id");
                i=2;
            }
            else {
                i=3;
                System.out.println("task update");
                list= list.stream().map(e->{
                    if(e.getTaskid()==id)
                    {
                        e.setTaskid(t.getTaskid());
                        e.setTask(t.getTask());
                        e.setPriority(t.getPriority());
                        e.setStatus(t.getStatus());
                    }
                    return e;
                }).collect(Collectors.toList());
            }
        }
        else {
            System.out.println("task id is not present");
        }
     return i;


//        list= list.stream().map(e->{
//            if(e.getTaskid()==id)
//            {
//               e.setTask(t.getTask());
//               e.setPriority(t.getPriority());
//               e.setStatus(t.getStatus());
//            }
//            return e;
//        }).collect(Collectors.toList());
    }


    public boolean isContains(int id)
    {
        boolean isPresent=false;
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getTaskid()==id)
            {
                isPresent=true;
                break;
            }
            else{
                isPresent=false;
            }
        }
        return isPresent;
    }





}

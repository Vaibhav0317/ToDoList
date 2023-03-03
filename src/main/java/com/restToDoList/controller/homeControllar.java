package com.restToDoList.controller;

import com.restToDoList.entity.task;
import com.restToDoList.service.taskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class homeControllar {

    @Autowired
    private taskService taskservice;
    @GetMapping("/getall")
    public ResponseEntity<?> getAllList()
    {
        String MsgFalse = "There are no Task in your List";
        HttpStatus statusNotOk = HttpStatus.NOT_FOUND;
        List<task> list=this.taskservice.getalltask();
        if(list.size()<=0)
        {
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return new ResponseEntity<>(MsgFalse, statusNotOk);
        }
        return  ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int Pid)
    {
        String MsgFalse = "Task Id "+Pid+" Not Found please enter correct Task Id";
        HttpStatus statusNotOk = HttpStatus.NOT_FOUND;
        HttpStatus statusOk = HttpStatus.OK;


           try {
               task t=null;
               t = this.taskservice.getTaskById(Pid);
               if (t == null) {
                   return new ResponseEntity<>(MsgFalse, statusNotOk);
               }
               else {
                   return new ResponseEntity<>(t, statusOk);

               }
           }catch (Exception e)
           {
               e.printStackTrace();
           }
           return ResponseEntity.status(HttpStatus.OK).build();
           // System.out.println("find by id t>===" + t);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTask(@RequestBody task t)
    {
        String MsgTrue = "Task Added Successfully";
        String MsgFalse = "Task Id already present please use different task id";
        HttpStatus statusOk = HttpStatus.OK;
        HttpStatus statusNotOk = HttpStatus.NOT_ACCEPTABLE;
        boolean b=this.taskservice.addTask(t);
        if(b==true)
        {
            return new ResponseEntity<>(MsgFalse, statusNotOk);
        }
        else
        {
            return new ResponseEntity<>(MsgTrue, statusOk);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") int Pid)
    {

        String MsgTrue = "Task Id "+Pid+" Found Task Deleted Successfully";
        String MsgFalse = "Task Id "+Pid+" Not Found please enter correct Task Id";
        HttpStatus statusOk = HttpStatus.OK;
        HttpStatus statusNotOk = HttpStatus.NOT_FOUND;

        //return new ResponseEntity<>(response, status);

        boolean b=this.taskservice.deleteTask(Pid);
        if(b==true)
        {
            //return ResponseEntity.status(HttpStatus.OK).build();
            return new ResponseEntity<>(MsgTrue, statusOk);
        }
        else
        {
          // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            return new ResponseEntity<>(MsgFalse, statusNotOk);
        }
    }
    @DeleteMapping("/deleteall")
    public ResponseEntity<?> deleteAll()
    {
        String MsgTrue = "Deleted All the Tasks Successfully";
        HttpStatus statusOk = HttpStatus.OK;
       this.taskservice.deleteall();
       System.out.println("delete all task successfully");
       return new ResponseEntity<>(MsgTrue, statusOk);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody task t,@PathVariable ("id") int id)
    {
       int i= this.taskservice.update(t,id);
       //if id not present i=0
        //task update with same id if both id are same i=1
        //task is already present please use different task id i=2
        //update task by using unique task id i=3;
        String str1="Task ID "+id+ "Not Found";
        String str2="Successfully Update Task Using Same Task Id "+id;
        String str3="Task ID "+t.getTaskid()+" is already present please use unique Task Id";
        String str4="Successfully Update Task using unique Task ID "+t.getTaskid();
        if(i==1)
        {
            return new ResponseEntity<>(str2,HttpStatus.OK);
        } else if (i==2) {
            return new ResponseEntity<>(str3,HttpStatus.ALREADY_REPORTED);
        } else if (i==3) {
            return new ResponseEntity<>(str4,HttpStatus.OK);
        }
        return new ResponseEntity<>(str1,HttpStatus.NOT_FOUND);
    }

}

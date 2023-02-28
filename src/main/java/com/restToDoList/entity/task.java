package com.restToDoList.entity;

import org.springframework.stereotype.Component;

@Component
public class task {
    private int taskid;
    private String task;
    private int priority;
    private String status;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public task( int taskid,String task, int priority, String status) {
        this.task = task;
        this.taskid = taskid;
        this.priority = priority;
        this.status = status;
    }

    @Override
    public String toString() {
        return "task{" +
                "taskid='" + taskid + '\'' +
                ", task=" + task +
                ", priority=" + priority +
                ", status='" + status + '\'' +
                '}';
    }

    public task() {
    }
}

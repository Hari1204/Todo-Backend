package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

//	@org.springframework.data.jpa.repository.Query("update task as tk set tk.task=?1 where tk.taskid=?2")
//	Task updateTask(String task, int taskid);

}

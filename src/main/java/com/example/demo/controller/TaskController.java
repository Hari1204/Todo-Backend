package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.services.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService service;
	@Autowired
	private TaskRepository repo;

	@CrossOrigin("http://localhost:4200/")
	@PostMapping("Task/create")
	@NonNull
	public Task Create(@RequestBody Task task) throws Exception
	{
		String taskdesc = task.getTask();
		if(taskdesc != null)
		{
			return repo.save(task);
		}
		else
		{
			throw new Exception("The task field shouldn't be Empty");
		}
		
	}
	
	@CrossOrigin("http://localhost:4200/")
	@GetMapping("Task/getTasks")
	public List<Task> getTasks()
	{
		return repo.findAll();
		
	}

	@CrossOrigin("http://localhost:4200/")
	@DeleteMapping("Task/Delete/{taskid}")
	public void Delete(@PathVariable int taskid)
	{
		repo.deleteById(taskid);	
	}
}

package com.projectmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanager.dao.TaskDaoImpl;
import com.projectmanager.model.Task;

@Service
public class TaskService {
	
	@Autowired
	TaskDaoImpl taskDaoImpl;

	public Task addTask(Task task) {
		// TODO Auto-generated method stub
		return taskDaoImpl.addTask(task);
	}

	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		return taskDaoImpl.updateTask(task);
	}

	public List<Task> getTasks() {
		// TODO Auto-generated method stub
		return taskDaoImpl.getTasks();
	}

	public Task updateEndTask(Task task) {
		// TODO Auto-generated method stub
		return taskDaoImpl.updateEndTask(task);
	}

	public Task getTask(int id) {
		// TODO Auto-generated method stub
		return taskDaoImpl.getTask(id);
	}

}

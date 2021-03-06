package com.greenfoxacademy.springstart.Services;

import com.greenfoxacademy.springstart.Models.Todo;
import com.greenfoxacademy.springstart.Models.User;
import com.greenfoxacademy.springstart.Repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TodoService {

  TodoRepository todoRepository;

  @Autowired
  TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public void addTodo(Todo todo) {
    if (todo != null) {
      this.todoRepository.save(todo);
    }
  }

  public List<Todo> getActive() {
    List<Todo> todos = todoRepository.findAll();
    List<Todo> todosActive = new ArrayList<>();

    for (int i = 0; i < todos.size(); i++) {
      if (!todos.get(i).isDone()) {
        todosActive.add(todos.get(i));
      }
    }
    return todosActive;
  }

  public void deleteTodo(long id) {
    todoRepository.deleteById(id);
  }

  public List<Todo> getSortById() {
    List<Todo> todos = todoRepository.findAll();
    Collections.sort(todos, new SortById());
    return todos;
  }

  public void editTodo(long id) {
    if (todoRepository.findById(id).isPresent()) {
      todoRepository.save(todoRepository.findById(id).get());
    }

  }

  public Todo getTodoById(long id) {
    return todoRepository.findById(id).get();
  }

  public void setUser(Todo todo, User user) {
    todo.setUser(user);
  }

  public List<Todo> getAllTodos() {
    return todoRepository.findAll();
  }

  public List<Todo> getAllTodosOfUser(User user) {
    List<Todo> todos = new ArrayList<>();

    for(Todo todoCurrent : todoRepository.findAll()) {
      if(todoCurrent.getUser() == user) {
        todos.add(todoCurrent);
      }
    }
    return todos;
  }



}

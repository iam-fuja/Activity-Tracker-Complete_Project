package com.example.activity_tracker.controller;

import com.example.activity_tracker.dto.requests.TaskEditDTO;
import com.example.activity_tracker.dto.requests.TaskResponseDTO;
import com.example.activity_tracker.model.Task;
import com.example.activity_tracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @RequestMapping ("/all-tasks")
    public ResponseEntity<List<TaskResponseDTO>> getUserTasks(){
        List<TaskResponseDTO> taskResponseDTOS = taskService.retrieveUserTasks();

        return new ResponseEntity<>(taskResponseDTOS, HttpStatus.OK);
    }

    //@GetMapping("/all-users")
    //    public ResponseEntity<List<CustomerResponseDto>> getAllUsers(){
    //        List<CustomerResponseDto> customerResponseDtos = customerService.getAllCustomers();
    //        return new ResponseEntity<>(customerResponseDtos, HttpStatus.OK);
    //    }

    @PostMapping("/create-task")
    public String createTask(@RequestBody TaskEditDTO task){
        taskService.createTask(task);
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
                //.ok().body(taskService.createTask(task));
        return "Task Created";
    }


    @RequestMapping("/{id}")
    public ResponseEntity<Task> editTask(@PathVariable Long id, @RequestBody TaskEditDTO task){

        return ResponseEntity.ok().body(taskService.editTask(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return new ResponseEntity("Task deleted", HttpStatus.ACCEPTED);
//        return ResponseEntity.ok().body(taskService.deleteTask(id));
    }
}
////@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
////	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
////
////		if (result.hasErrors()) {
////			return "todo";
////		}
////
////		todo.setUserName(getLoggedInUserName(model));
////		todoService.updateTodo(todo);
////		return "redirect:/list-todos";
////	}
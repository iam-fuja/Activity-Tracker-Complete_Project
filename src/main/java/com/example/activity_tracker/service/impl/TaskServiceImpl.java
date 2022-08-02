package com.example.activity_tracker.service.impl;

import com.example.activity_tracker.dto.requests.TaskEditDTO;
import com.example.activity_tracker.dto.requests.TaskResponseDTO;
import com.example.activity_tracker.enums.Status;
import com.example.activity_tracker.model.Task;
import com.example.activity_tracker.model.User;
import com.example.activity_tracker.repository.TaskRepository;
import com.example.activity_tracker.repository.UserRepository;
import com.example.activity_tracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    @Override
    public List<TaskResponseDTO> retrieveUserTasks() {

        List<Task> userTask = taskRepository.findAll();
        List<TaskResponseDTO> taskResponseDTOS = new ArrayList<>();
        for (Task task: userTask){
            TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
            taskResponseDTO.setDescription(task.getDescription());
            taskResponseDTO.setCompletedDate(task.getCompletedDate());
            taskResponseDTO.setModifiedDate(task.getModifiedDate());
            taskResponseDTO.setTitle(task.getTitle());
            taskResponseDTOS.add(taskResponseDTO);
        }
        return taskResponseDTOS;
    }


    //public List<CustomerResponseDto> getAllCustomers() {
    //        List<Customer> customerList = customerRepository.findAll();
    //        List<CustomerResponseDto> customerResponseDtos = new ArrayList<>();
    //        for (Customer customerdt: customerList) {
    //            CustomerResponseDto customerResponseDto = new CustomerResponseDto();
    //            customerResponseDto.setName(customerdt.getName());
    //            customerResponseDto.setAge(customerdt.getAge());
    //            customerResponseDto.setEmail(customerdt.getEmail());
    //            customerResponseDtos.add(customerResponseDto);
    //        }
    //        return customerResponseDtos;
    //    }




    @Override
    public Task createTask(TaskEditDTO task) {

       User user = getLoggedInUser();

        Task createdTask = Task.builder()
                .title(task.getTitle())
                .description(task.getDescription())
                .status(Status.PENDING)
                .user(user)
                .completedDate(task.getCompletedDate())
                .modifiedDate(task.getModifiedDate())
                .build();

        return taskRepository.save(createdTask);
    }

    @Override
    public Task editTask(Long id, TaskEditDTO task) {

        User user = getLoggedInUser();

        Task editedTask = taskRepository.findById(id).orElseThrow(()->new RuntimeException());
        editedTask.setTitle(task.getTitle());
//        .title(task.getTitle())
//                .description(task.getDescription())
//                .status(Status.DONE)
//                .user(user)
//                .completedDate(task.getCompletedDate())
//                .modifiedDate(task.getModifiedDate())
//                .build();
        return taskRepository.save(editedTask);
    }

    @Override
    public Task deleteTask(Long id) {

        Task task =taskRepository.findById(id)
                .orElseThrow(()->new RuntimeException("task not found"));
        taskRepository.delete(task);

    return task;}

    private User getLoggedInUser(){
       return userRepository.findById(1L).orElseThrow(()-> new ResourceNotFoundException("user not found"));
    }
}


//@Override
//    public void deleteCustomer(Long id) {
//        Customer customer = customerRepository.findById(id)
//                .orElseThrow(()-> new CustomAppException("user does not exist"));
//        customerRepository.delete(customer);
//    }
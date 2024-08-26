package com.example.capstone3ee.Controller;


import com.example.capstone3ee.Model.Request;
import com.example.capstone3ee.Service.RequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;

    // GET all requests
    @GetMapping("/get")
    public ResponseEntity getAllRequests() {
        List<Request> requests = requestService.getAllRequests();
        return  ResponseEntity.status(200).body(requests);
    }

    // ADD a new request
    @PostMapping("/add/{expertId}/{userId}")
    public ResponseEntity addRequest(@PathVariable Integer expertId , @PathVariable Integer userId ,@Valid @RequestBody Request request) {
        requestService.addRequest(expertId,userId,request);
        return ResponseEntity.status(200).body("Request added successfully");
    }

    // UPDATE an existing request
    @PutMapping("/update/{id}")
    public ResponseEntity updateRequest(@PathVariable Integer id, @Valid @RequestBody Request request) {
        requestService.updateRequest(id, request);
        return ResponseEntity.status(200).body("Request updated Successfully");
    }

    // DELETE a request
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteRequest(@PathVariable Integer id) {
        requestService.deleteRequest(id);
        return  ResponseEntity.status(200).body("Request deleted Successfully");
    }


}

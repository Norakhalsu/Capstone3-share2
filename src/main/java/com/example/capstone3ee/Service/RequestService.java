package com.example.capstone3ee.Service;

import com.example.capstone3ee.Api.ApiException;
import com.example.capstone3ee.Model.Expert;
import com.example.capstone3ee.Model.Request;
import com.example.capstone3ee.Model.User;
import com.example.capstone3ee.Repository.ExpertRepository;
import com.example.capstone3ee.Repository.RequestRepository;
import com.example.capstone3ee.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestRepository requestRepository;
    private final ExpertRepository expertRepository;
    private final UserRepository userRepository;

    // GET
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    // must check if expert and user is exisit in system
    public void addRequest(Integer expertId,Integer userId,Request request) {
        Expert expert=expertRepository.findExpertById(expertId);
        User user=userRepository.findUserById(userId);
        if (expert==null) {
            throw new ApiException("expert is null");
        }
        if (user==null) {
            throw new ApiException("user is null");
        }
        request.setExpert(expert);
        request.setUser(user);
        requestRepository.save(request);
    }


    // UPDATE
    public Request updateRequest(Integer id, Request request) {
        Request request1 = requestRepository.findRequestById(id);
        if (request1==null) {
            throw new ApiException("request is null");
        }
       // request1.setExpertId(request.getExpertId());
        request1.setStatus(request.getStatus());
        return requestRepository.save(request);
    }



    // DELETE
    public void deleteRequest(Integer id) {
        requestRepository.deleteById(id);
    }
}

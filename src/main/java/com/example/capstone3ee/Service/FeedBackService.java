package com.example.capstone3ee.Service;

import com.example.capstone3ee.Api.ApiException;
import com.example.capstone3ee.DTO.FeedBackDTO;
import com.example.capstone3ee.Model.FeedBack;
import com.example.capstone3ee.Model.Request;
import com.example.capstone3ee.Repository.FeedBackRepository;
import com.example.capstone3ee.Repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedBackService {

    private final FeedBackRepository feedbackRepository;
    private final RequestRepository requestRepository;

    // GET
    public List<FeedBack> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    // ADD
    public void addFeedback(FeedBackDTO feedBackDTO) {
        Request request=requestRepository.findRequestById(feedBackDTO.getRequestId());
        if (request==null){
            throw new ApiException("Request not found");
        }
        FeedBack feedBack=new FeedBack(null,feedBackDTO.getFeedbackText(),request);
        feedbackRepository.save(feedBack);
    }

    // UPDATE
    public void updateFeedback(FeedBackDTO feedBackDTO) {
        FeedBack feedBack = feedbackRepository.findFeedBackById(feedBackDTO.getRequestId());
        if (feedBack == null) {
            throw new RuntimeException("Feedback not found");
        }
        feedBack.setFeedbackText(feedBackDTO.getFeedbackText());
        feedbackRepository.save(feedBack);
    }

    // DELETE
    public void deleteFeedback(Integer id) {
        FeedBack feedback = feedbackRepository.findFeedBackById(id);
        if (feedback == null) {
            throw new RuntimeException("Feedback not found");
        }
        feedbackRepository.deleteById(id);
    }





}
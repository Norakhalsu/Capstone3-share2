package com.example.capstone3ee.Service;

import com.example.capstone3ee.Api.ApiException;
import com.example.capstone3ee.Model.Groups;
import com.example.capstone3ee.Model.User;
import com.example.capstone3ee.Repository.GroupsRepository;
import com.example.capstone3ee.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class GroupsService {
    private final GroupsRepository groupsRepository;
    private final UserRepository userRepository;


        public List<Groups> getAllGroup() {
            return groupsRepository.findAll();}


        public void addGroup(Groups group) {
            groupsRepository.save(group);
        }

        public void updateGroup(Integer id ,Groups group) {
            Groups group1=groupsRepository.findGroupById(id);

            if(group1==null) {
                throw new ApiException("group not found");
            }
            group1.setName(group.getName());
            group1.setDescription(group.getDescription());
            group1.setApplicable(group.isApplicable());
            group1.setProjects(group.getProjects());
            group1.setMembers(group.getMembers());
            groupsRepository.save(group);
        }

        public void deleteGroup(Integer id) {
            Groups group=groupsRepository.findGroupById(id);
            if(group==null) {
                throw new ApiException("group not found");
            }
            groupsRepository.delete(group);
        }

        //List<Integer> // assign users to group
        public void assignUsersToGroups(Integer groupId, Integer userIds) {
            Groups group=groupsRepository.findGroupById(groupId);
            User users=userRepository.findUserById(userIds);
            if(group==null) {
                throw new ApiException("group not found");
            }
            if(users==null) {
                throw new ApiException("user not found");
            }
            group.getUsers().add(users);
            users.getGroups().add(group);
            userRepository.save(users);
            groupsRepository.save(group);


        }





}

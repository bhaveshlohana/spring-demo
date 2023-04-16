package com.bhavesh.demo.Service;

import com.bhavesh.demo.DAO.TopicRepository;
import com.bhavesh.demo.Model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopicsList() {
//        return topicsList;
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopicById(String id) {
//        return topicsList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
            return topicRepository.findById(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        return topicsList.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }

    public void updateTopic(String id, Topic updatedTopic) {
        topicRepository.save(updatedTopic);
//        System.out.println("In service");
//        for (int i = 0; i < topicsList.size(); i++) {
//            if (topicsList.get(i).getId().equals(id)) {
//                topicsList.set(i, updatedTopic);
//                return topicsList.get(i);
//            }
//        }
//        for(Topic t: topicsList) {
//            if(t.getId().equals(id)) {
//                t.setName(topic.getName());
//                t.setDescription(topic.getDescription());
//                return t;
//            }
//        }

    }
}

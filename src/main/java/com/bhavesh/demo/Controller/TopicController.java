package com.bhavesh.demo.Controller;

import com.bhavesh.demo.Model.Topic;
import com.bhavesh.demo.Service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("/404")
    public String error() {
        return "Oops, Error 404 mate, fix it.";
    }
    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopicsList();
    }
    @GetMapping("/topics/{id}")
    public Optional<Topic> getTopicById(@PathVariable String id) {
        return topicService.getTopicById(id);
    }

    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @DeleteMapping("/topics/{id}")
    public void  deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }

    @PutMapping("/topics/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Topic updatedTopic) {
//        return topicService.updateTopic(id, topic) == true ? "The topic has been updated" : " Something went wrong :(";
        topicService.updateTopic(id, updatedTopic);

    }
}

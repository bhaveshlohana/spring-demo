package com.bhavesh.demo.Controller;

import com.bhavesh.demo.Model.Course;
import com.bhavesh.demo.Model.Topic;
import com.bhavesh.demo.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId) {
        return courseService.getAllCoursesByTopic(topicId);
    }
    @GetMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getCourseById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/topics/{topicId}/courses")
    public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
            course.setTopic(new Topic(topicId, "", ""));
            courseService.addCourse(course);
    }

    @DeleteMapping("/topics/{topicId}/courses/{id}")
    public void  deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("/topics/{topicId}/courses/{id}")
    public void updateCourse(@PathVariable String topicId, @PathVariable String id, @RequestBody Course updatedCourse) {
        updatedCourse.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(updatedCourse);

    }
}

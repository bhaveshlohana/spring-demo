package com.bhavesh.demo.Service;

import com.bhavesh.demo.DAO.CourseRepository;
import com.bhavesh.demo.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCoursesByTopic(String topicId) {
//        return coursesList;
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourseById(String id) {
//        return coursesList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return courseRepository.findById(id);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
//        return coursesList.removeIf(t -> t.getId().equals(id));
        courseRepository.deleteById(id);
    }

    public void updateCourse(Course updatedCourse) {
        courseRepository.save(updatedCourse);

    }
}

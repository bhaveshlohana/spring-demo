package com.bhavesh.demo.DAO;

import com.bhavesh.demo.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {
    public List<Course> findByTopicId(String topicId);
}

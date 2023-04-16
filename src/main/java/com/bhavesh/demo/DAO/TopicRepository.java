package com.bhavesh.demo.DAO;

import com.bhavesh.demo.Model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, String>{
}

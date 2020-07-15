package com.example.demohazelcast.repo;

import com.example.demohazelcast.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HazelCastRepo extends JpaRepository<Book, Integer> {



}

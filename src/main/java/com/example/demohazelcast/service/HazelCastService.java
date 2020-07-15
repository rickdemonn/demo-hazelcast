package com.example.demohazelcast.service;

import com.example.demohazelcast.exception.BookNotFoundException;
import com.example.demohazelcast.model.Book;
import com.example.demohazelcast.repo.HazelCastRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HazelCastService {
    private final HazelCastRepo hazelCastRepo;

    public HazelCastService(HazelCastRepo hazelCastRepo) {
        this.hazelCastRepo = hazelCastRepo;
    }

    public Book getOne(Integer id) {
        return hazelCastRepo.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public List<Book> findAll() {
        return hazelCastRepo.findAll();
    }

    public Book create(Book book) {
        return hazelCastRepo.save(book);
    }

    public Book update(Integer id, Book book) {
        Book bookFromDb = hazelCastRepo.findById(id).orElseThrow(BookNotFoundException::new);
        bookFromDb.setTitle(book.getTitle());
        bookFromDb.setAuthor(book.getAuthor());
        return hazelCastRepo.save(bookFromDb);
    }

    public void delete(Integer id) {
        hazelCastRepo.deleteById(id);
    }
}

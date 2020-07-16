package com.example.demohazelcast.service;

import com.example.demohazelcast.exception.BookNotFoundException;
import com.example.demohazelcast.model.Book;
import com.example.demohazelcast.repo.HazelCastRepo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class HazelCastService {
    private final HazelCastRepo hazelCastRepo;

    public HazelCastService(HazelCastRepo hazelCastRepo) {
        this.hazelCastRepo = hazelCastRepo;
    }

    @SneakyThrows
    @Cacheable("books")
    public Book getOne(Integer id) {
        log.info("get one");
        Thread.sleep(2000);
        return hazelCastRepo.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @SneakyThrows
    @Cacheable("books")
    @Scheduled(fixedRate = 8000)
    public List<Book> findAll() {
        log.info("find all is started");
        Thread.sleep(2000);
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

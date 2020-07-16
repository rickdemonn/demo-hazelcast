package com.example.demohazelcast.service;

import com.example.demohazelcast.exception.BookNotFoundException;
import com.example.demohazelcast.model.Book;
import com.example.demohazelcast.repo.HazelCastRepo;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
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

    /*
    when book added or deleted getOne works from cache
     */
    @SneakyThrows
    @Cacheable(value = "books", key = "#id")
    public Book getOne(Integer id) {
        log.info("get one");
        Thread.sleep(2000);
        return hazelCastRepo.findById(id).orElseThrow(BookNotFoundException::new);
    }

    /*
    Do not updating cache when book added or deleted гтешд scheduling starts
     */
    @SneakyThrows
    @Cacheable("books")
    @Scheduled(fixedRate = 8000)
    public List<Book> findAll() {
        log.info("find all is started");
        Thread.sleep(2000);
        return hazelCastRepo.findAll();
    }

    @CachePut(value = "books", key = "#book.id")
    public Book create(Book book) {
        return hazelCastRepo.save(book);
    }

    @CachePut("books")
    public Book update(Integer id, Book book) {
        Book bookFromDb = hazelCastRepo.findById(id).orElseThrow(BookNotFoundException::new);
        bookFromDb.setTitle(book.getTitle());
        bookFromDb.setAuthor(book.getAuthor());
        return hazelCastRepo.save(bookFromDb);
    }

    @CacheEvict(value = "books", key = "#id")
    public void delete(Integer id) {
        hazelCastRepo.deleteById(id);
    }
}

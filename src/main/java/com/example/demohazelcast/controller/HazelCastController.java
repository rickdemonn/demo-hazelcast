package com.example.demohazelcast.controller;

import com.example.demohazelcast.model.Book;
import com.example.demohazelcast.service.HazelCastService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class HazelCastController {

    private final HazelCastService hazelCastService;

    public HazelCastController(HazelCastService hazelCastService) {
        this.hazelCastService = hazelCastService;
    }

    @GetMapping("/{id}")
    public Book getOne(@PathVariable Integer id) {
        return hazelCastService.getOne(id);
    }

    @GetMapping
    public List<Book> findAll() {
        return hazelCastService.findAll();
    }

    @PostMapping
    public Book create(@RequestBody Book book){
        return hazelCastService.create(book);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Integer id, @RequestBody Book book) {
        return hazelCastService.update(id, book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        hazelCastService.delete(id);
    }
}

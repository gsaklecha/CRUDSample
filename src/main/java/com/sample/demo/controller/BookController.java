package com.sample.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.exception.PersistException;
import com.sample.demo.exception.RecordNotFoundException;
import com.sample.demo.exception.StateNotMatchException;
import com.sample.demo.model.BookEntity;
import com.sample.demo.service.IBookService;

@RestController
@RequestMapping("/books")
public class BookController {
	@Autowired
	IBookService service;

	@GetMapping
	public ResponseEntity<List<BookEntity>> getAllBooks() {
		List<BookEntity> list = service.getAllBooks();
		return new ResponseEntity<List<BookEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookEntity> getBookById(@PathVariable("id") Long id) throws RecordNotFoundException {
		BookEntity entity = service.getBookById(id);
		return new ResponseEntity<BookEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity book) throws PersistException {
		BookEntity created = service.createBook(book);
		return new ResponseEntity<BookEntity>(created, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<BookEntity> updateBook(@RequestBody BookEntity book)
			throws StateNotMatchException, PersistException {
		BookEntity updated = service.updateBook(book);
		return new ResponseEntity<BookEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/{versionId}")
	public HttpStatus deleteBookById(@PathVariable("versionId") String versionId) throws StateNotMatchException {
		service.deleteBookByVersionId(versionId);
		return HttpStatus.OK;
	}

}
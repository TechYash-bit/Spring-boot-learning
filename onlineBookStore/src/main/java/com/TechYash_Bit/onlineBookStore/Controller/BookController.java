package com.TechYash_Bit.onlineBookStore.Controller;


import com.TechYash_Bit.onlineBookStore.Dto.BookDto;
import com.TechYash_Bit.onlineBookStore.Services.BookService;
import com.TechYash_Bit.onlineBookStore.exception.ResourseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(path = "/book")
public class BookController {
    final  private BookService bookService;

    BookController(BookService bookService){
        this.bookService=bookService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BookDto>> getAllbook(){
        return ResponseEntity.ok(bookService.getAllBook());
    }

    @PostMapping( path = "/addBook")
    public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto){
        BookDto bookDto1=bookService.AddBook(bookDto);
        return new ResponseEntity<>(bookDto1, HttpStatus.CREATED);

    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<BookDto> findBookById(@PathVariable int id){
        Optional<BookDto> bookDto= bookService.findBookById(id);
        return bookDto.map(ResponseEntity::ok).orElseThrow(()-> new ResourseNotFoundException("book not found "+id));
        //return ResponseEntity.ok(bookService.findBookById(id)).build();
    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<BookDto> updateBookInfo(@PathVariable int id,@RequestBody BookDto bkdto){
        return ResponseEntity.ok(bookService.updateBook(id,bkdto));
    }


    @PatchMapping(path = "/partialupdate/{id}")
    public ResponseEntity<BookDto> partialUpdate(@PathVariable int id, @RequestBody Map<String,Object> updates){
        BookDto bookDto=bookService.partialUpdate(id,updates);
        if (bookDto==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(bookDto);
    }
}

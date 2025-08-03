package com.TechYash_Bit.onlineBookStore.Services;

import com.TechYash_Bit.onlineBookStore.Dto.BookDto;
import com.TechYash_Bit.onlineBookStore.Entities.BookEntity;
import com.TechYash_Bit.onlineBookStore.Repositories.BookRepo;
import com.TechYash_Bit.onlineBookStore.exception.ResourseNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    final private BookRepo bookRepo;
    private ModelMapper modelMapper;

    BookService(BookRepo bookRepo,ModelMapper modelMapper){
        this.bookRepo=bookRepo;
        this.modelMapper=modelMapper;
    }

    public List<BookDto> getAllBook(){
        List<BookEntity> list=bookRepo.findAll();
        return list.stream()
                .map(entity -> modelMapper.map(entity,BookDto.class) )
                .collect(Collectors.toList());
    }

    public BookDto AddBook(BookDto bookDto) {
        BookEntity bookEntity=modelMapper.map(bookDto,BookEntity.class);
        bookRepo.save(bookEntity);
        return modelMapper.map(bookEntity,BookDto.class);
    }



    public Optional<BookDto> findBookById(int id) {
        return bookRepo.findById(id).map(bookEntity -> modelMapper.map(bookEntity,BookDto.class));
    }



    public BookDto updateBook(int id, BookDto bkdto) {
        if(!isBookExist(id))
        {
            throw new ResourseNotFoundException("Book not found with id"+id);
        }
        BookEntity bkentity=bookRepo.findById(id)
                .orElseThrow(()->new ResourseNotFoundException("book not present with id "+id));
        bkentity.setTitle(bkdto.getTitle());
        bkentity.setCategory(bkdto.getCategory());
        bkentity.setAuthor(bkdto.getAuthor());
        bkentity.setQuantity(bkdto.getQuantity());
        bkentity.setPrice(bkdto.getPrice());
        bookRepo.save(bkentity);

        return modelMapper.map(bkentity,BookDto.class);

    }
    public boolean isBookExist(int id){
        return bookRepo.existsById(id);
    }

    public BookDto partialUpdate(int id, Map<String, Object> updates) {
        if(!isBookExist(id)) return null;
        BookEntity bkentity=bookRepo.findById(id).get();

        updates.forEach((key,value)->{
            Field field= ReflectionUtils.findField(BookEntity.class,key);
            if (field!=null){
                field.setAccessible(true);
                ReflectionUtils.setField(field,bkentity,value);
            }
        });
        return modelMapper.map(bookRepo.save(bkentity),BookDto.class);
    }
}

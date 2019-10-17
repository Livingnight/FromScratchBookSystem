package com.company.noteservice.dao;

import com.company.noteservice.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer>{
    List<Note> findNoteByBookId(Integer bookId);
}

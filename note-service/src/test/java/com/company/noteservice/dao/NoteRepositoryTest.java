package com.company.noteservice.dao;

import com.company.noteservice.model.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NoteRepositoryTest {

    @Autowired
    private NoteRepository noteRepository;

    @BeforeEach
    void setUp() {
        noteRepository.deleteAll();
    }

    @Test
    void findNoteByBookId() {
        //Arrange
        int bookId=1;
        List<Note> expected = new ArrayList<>();
        Note note1 = buildNote(1,1,"My Note 1");
        Note note2 = buildNote(2,2,"My Note 2");
        Note note3 = buildNote(3,1,"My Note 3");

        noteRepository.save(note1);
        noteRepository.save(note2);
        noteRepository.save(note3);

        expected.add(note1);
        expected.add(note3);
        //Act
        List<Note> actualNotes = noteRepository.findNoteByBookId(bookId);
        assertEquals(2, actualNotes.size());
        assertFalse(actualNotes.contains(note2));
        assertTrue(expected.containsAll(actualNotes));
        assertTrue(actualNotes.containsAll(expected));

    }

    public Note buildNote(Integer noteId, Integer bookId, String note){
        Note noteToCreate = new Note();
        noteToCreate.setNoteId(noteId);
        noteToCreate.setBookId(bookId);
        noteToCreate.setNote(note);
        return noteToCreate;
    }
}
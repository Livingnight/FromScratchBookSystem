package com.company.noteservice.service;

import com.company.noteservice.model.Note;
import com.company.noteservice.viewModel.NoteViewModel;

public class NoteService {


    protected NoteViewModel buildNoteViewModel(Note note) {
        NoteViewModel nvm = new NoteViewModel();
        nvm.setNoteId(note.getNoteId());
        nvm.setBookId(note.getBookId());
        nvm.setNote(note.getNote());
        return nvm;
    }
}

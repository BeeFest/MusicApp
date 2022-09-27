package com.ilionx.musicapp.controllers;

import com.ilionx.musicapp.model.MusicInstrument;
import com.ilionx.musicapp.repositories.MusicInstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/musicinstruments")
public class MusicInstrumentController {

    @Autowired
    private MusicInstrumentRepository musicInstrumentRepository;

    @GetMapping
    public List<MusicInstrument> list() {
        return this.musicInstrumentRepository.findAll();
    }

}

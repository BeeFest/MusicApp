package com.ilionx.musicapp.controllers;

import com.ilionx.musicapp.model.MusicInstrument;
import com.ilionx.musicapp.repositories.MusicInstrumentRepository;
import com.ilionx.musicapp.service.MusicInstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/musicinstruments")
public class MusicInstrumentController {
    @Autowired
    private MusicInstrumentService musicInstrumentService;
    @GetMapping
    public ResponseEntity<List<MusicInstrument>> cars() {
        return ResponseEntity.ok(musicInstrumentService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable long id){
        Optional<MusicInstrument> optional = musicInstrumentService.findById(id);
        if (optional.isEmpty()){
            return ResponseEntity.status(404).body(String.format("This musicinstrument with id: %d cannot be found.", id));
        }else return ResponseEntity.ok(optional.get());
    }
    @PostMapping
    public ResponseEntity<MusicInstrument> create(@RequestBody MusicInstrument musicInstrument) throws URISyntaxException {
        MusicInstrument result = this.musicInstrumentService.save(musicInstrument);
        return ResponseEntity.created(new URI("api/musicinstruments/" +result.getId())).body(result);
    }
    @PutMapping("{id}")
    public ResponseEntity<MusicInstrument> updateById(@PathVariable long id, @RequestBody MusicInstrument source) {
        Optional<MusicInstrument> optionalInstrument = musicInstrumentService.updateById(id, source);
        if(optionalInstrument.isPresent()) {
            return ResponseEntity.ok(optionalInstrument.get());
        }else
            return ResponseEntity.notFound().build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<MusicInstrument> deleteById (@PathVariable long id) {
        Optional<MusicInstrument> optionalInstrument = this.musicInstrumentService.findById(id);
        if(optionalInstrument.isPresent()) {
            this.musicInstrumentService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else return ResponseEntity.notFound().build();
    }
}

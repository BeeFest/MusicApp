package com.ilionx.musicapp.service;

import com.ilionx.musicapp.model.MusicInstrument;
import com.ilionx.musicapp.repositories.MusicInstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.MappedSuperclass;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MusicInstrumentService {

    @Autowired
    private MusicInstrumentRepository musicInstrumentRepository;

    public List<MusicInstrument> findAll() {
        return musicInstrumentRepository.findAll();
    }

    @Transactional
    public MusicInstrument save(MusicInstrument car) {
        MusicInstrument savedInstrument = this.musicInstrumentRepository.save(car);
        return savedInstrument;
    }

    public Optional<MusicInstrument> findById(Long aLong) {
        return musicInstrumentRepository.findById(aLong);
    }

    public long count() {
        return musicInstrumentRepository.count();
    }

    public void deleteById(Long aLong) {
        musicInstrumentRepository.deleteById(aLong);
    }

    public void delete(MusicInstrument entity) {
        musicInstrumentRepository.delete(entity);
    }

    public Optional<MusicInstrument> updateById(@PathVariable long id, @RequestBody MusicInstrument source) {
        Optional<MusicInstrument> optionalInstrument = findById(id);
        if (optionalInstrument.isPresent()) {
            MusicInstrument target = optionalInstrument.get();
            target.setName(source.getName());
            target.setHasStrings(source.getHasStrings());
            target.setOrchestraGroup(source.getOrchestraGroup());
            target.setNumberInOrchestra(source.getNumberInOrchestra());
            this.musicInstrumentRepository.save(target);
        }
        return optionalInstrument;
    }
}

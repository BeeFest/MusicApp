package com.ilionx.musicapp.repositories;

import com.ilionx.musicapp.model.MusicInstrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicInstrumentRepository extends JpaRepository<MusicInstrument, Long> {

}

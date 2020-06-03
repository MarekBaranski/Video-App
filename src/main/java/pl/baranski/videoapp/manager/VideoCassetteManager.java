package pl.baranski.videoapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.baranski.videoapp.dao.VideoCassetteRepo;
import pl.baranski.videoapp.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {

    private VideoCassetteRepo videoCassetteRepo;

    @Autowired
    public VideoCassetteManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    public Optional<VideoCassette> findById(Long id) {
        return videoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCassetteRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette) {
        return videoCassetteRepo.save(videoCassette);
    }

    public void deleteById(Long id) {
        videoCassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB () {
        save(new VideoCassette(1L, "Titanic", LocalDate.of(1997, 1, 1)));
        save(new VideoCassette(2L, "Notting Hill", LocalDate.of(1999, 4, 25)));
        save(new VideoCassette(3L, "Rambo", LocalDate.of(1982, 9, 20)));
    }

}

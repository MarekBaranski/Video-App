package pl.baranski.videoapp.api;

import org.springframework.web.bind.annotation.*;
import pl.baranski.videoapp.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts")
public class VideoCassetteApi {

    private List<VideoCassette> videoCassettes;

    public VideoCassetteApi() {
        videoCassettes = new ArrayList<>();
        videoCassettes.add(new VideoCassette(1L, "Titanic", LocalDate.of(1997,1,1)));
        videoCassettes.add(new VideoCassette(2L, "Notting Hill", LocalDate.of(1999,4,25)));
        videoCassettes.add(new VideoCassette(3L, "Rambo", LocalDate.of(1982,9,20)));
    }

    @GetMapping("/all")
    public List<VideoCassette> getAll(){
        return videoCassettes;
    }

    @GetMapping
    public VideoCassette getById(@RequestParam int index){
        Optional<VideoCassette> first = videoCassettes.stream().filter(element -> element.getId() == index).findFirst();
        return first.get();
    }

    @PostMapping
    public boolean addVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.add(videoCassette);
    }

    @PutMapping
    public boolean updateVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassettes.add(videoCassette);
    }

    @DeleteMapping
    public boolean deleteById(@RequestParam int index){
        return videoCassettes.removeIf(element -> element.getId() == index);
    }
}

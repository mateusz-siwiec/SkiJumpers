package pl.mateusz.siwiec.controllers;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.mateusz.siwiec.SkiJumper;
import pl.mateusz.siwiec.SkiJumpersRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SkiJumpersController {

    SkiJumpersRepository skiJumpersRepository = new SkiJumpersRepository();

    @GetMapping("/skiJumpers")
    public List<SkiJumper> getAllSkiJumpers(@RequestParam(value = "filter", required = false, defaultValue = "") String namePhrase) {

        return skiJumpersRepository.getSkiJumpers().stream()
                .filter(skiJumper -> skiJumper.getName().startsWith(namePhrase))
                .collect(Collectors.toList());
    }

    @PostMapping("/skiJumpers")
    public ResponseEntity addSkiJumper(@RequestBody SkiJumper skiJumper) {
        if (skiJumpersRepository.validateJumper(skiJumper)) {
            skiJumpersRepository.addJumper(skiJumper);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity("You can't add jumper", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/skiJumpers/{id}")
    public ResponseEntity editSkiJumper(@RequestBody SkiJumper skiJumper, @PathVariable int id) {
        if (skiJumpersRepository.validateJumper(skiJumper)) {
            skiJumpersRepository.editJumper(skiJumper, id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity("You can't edit jumper" ,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/skiJumpers/{id}")
    public void deleteSkiJumper(@PathVariable int id) {
        skiJumpersRepository.deleteJumper(id);
    }
}

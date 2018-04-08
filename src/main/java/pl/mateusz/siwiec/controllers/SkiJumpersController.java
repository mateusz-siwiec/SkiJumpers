package pl.mateusz.siwiec.controllers;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.siwiec.SkiJumper;

import java.util.List;
import java.util.stream.Collectors;
import pl.mateusz.siwiec.repositories.SkiJumpersRepository;

@RestController
public class SkiJumpersController {

    @Autowired
    private SkiJumpersRepository skiJumpersRepository;

    @Transactional
    @GetMapping("/skiJumpers")
    public List<SkiJumper> getAllSkiJumpers(@RequestParam(value = "filter", required = false, defaultValue = "") String namePhrase) {
        return skiJumpersRepository.getSkiJumpers().stream()
                .filter(skiJumper -> skiJumper.getName().startsWith(namePhrase))
                .collect(Collectors.toList());
    }

    @PostMapping("/skiJumpers")
    public ResponseEntity addSkiJumper(@RequestBody SkiJumper skiJumper) {
        if (validateJumper(skiJumper)) {
            skiJumpersRepository.addJumper(skiJumper);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity("You can't add jumper", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/skiJumpers/{id}")
    public ResponseEntity editSkiJumper(@RequestBody SkiJumper skiJumper, @PathVariable int id) {
        if (validateJumper(skiJumper)) {
            skiJumpersRepository.editJumper(skiJumper, id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity("You can't edit jumper" ,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/skiJumpers/{id}")
    public void deleteSkiJumper(@PathVariable int id) {
        skiJumpersRepository.deleteJumper(id);
    }

    public boolean validateJumper(SkiJumper skiJumper) {
        String regex = "^[a-zA-Z]+$";
        return skiJumper.getWinsInCareerInWorldCup() > 0
            && skiJumper.getPodiumsInCareerInWorldCup() > 0
            && skiJumper.getName().matches(regex) && skiJumper.getName().length() > 1
            && skiJumper.getNation().matches(regex) && skiJumper.getNation().length() > 1
            && skiJumper.getSurname().matches(regex) && skiJumper.getSurname().length() > 1;
    }

}

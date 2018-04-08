package pl.mateusz.siwiec.controllers;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.siwiec.SkiJumper;

import java.util.List;
import java.util.stream.Collectors;

import pl.mateusz.siwiec.SkiJumperValidator;
import pl.mateusz.siwiec.repositories.SkiJumpersRepository;

/**
 * This class is a REST controller for ski jumpers
 */
@RestController
public class SkiJumpersController {
    private SkiJumperValidator skiJumperValidator = new SkiJumperValidator();

    @Autowired
    private SkiJumpersRepository skiJumpersRepository;

    /**
     * GET method to get all ski jumpers
     * @param namePhrase
     * @return
     */
    @Transactional
    @GetMapping("/skiJumpers")
    public List<SkiJumper> getAllSkiJumpers(@RequestParam(value = "filter", required = false, defaultValue = "") String namePhrase) { //method to get all ski jumper
        return skiJumpersRepository.getSkiJumpers().stream()
                .filter(skiJumper -> skiJumper.getName().startsWith(namePhrase))
                .collect(Collectors.toList());
    }

    /**
     * POST method to add new ski jumper
     * @param skiJumper ski jumper to add
     * @return OK if ski jumper was added, BAD_REQUEST if provided ski jumper was invalid
     */
    @PostMapping("/skiJumpers")
    public ResponseEntity addSkiJumper(@RequestBody SkiJumper skiJumper) {
        if (skiJumperValidator.validateJumper(skiJumper)) {
            skiJumpersRepository.addJumper(skiJumper);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity("You can't add jumper", HttpStatus.BAD_REQUEST);
    }

    /**
     * @param skiJumper ski jumper to edit
     * @param id ski jumper id
     * @return OK when ski jumper was edited , BAD_REQUEST when ski jumper hasn't been edited
     */
    @PutMapping("/skiJumpers/{id}")
    public ResponseEntity editSkiJumper(@RequestBody SkiJumper skiJumper, @PathVariable int id) {
        if (skiJumperValidator.validateJumper(skiJumper)) {
            skiJumpersRepository.editJumper(skiJumper, id);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity("You can't edit jumper" ,HttpStatus.BAD_REQUEST);
    }

    /**
     * DELETE method to delete ski jumper
     * @param id ski jumper id
     */
    @DeleteMapping("/skiJumpers/{id}")
    public void deleteSkiJumper(@PathVariable int id) {
        skiJumpersRepository.deleteJumper(id);
    }
}

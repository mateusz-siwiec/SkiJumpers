package pl.mateusz.siwiec.controllers;

import org.springframework.web.bind.annotation.*;
import pl.mateusz.siwiec.SkiJumper;
import pl.mateusz.siwiec.SkiJumpersRepository;

import java.util.List;

@RestController
public class SkiJumpersController {

    SkiJumpersRepository skiJumpersRepository = new SkiJumpersRepository();

    @GetMapping("/skiJumpers")
    public List<SkiJumper> getAllSkiJumpers(){
        return skiJumpersRepository.getSkiJumpers();
    }

    @PostMapping("/skiJumpers")
    public void addSkiJumper(@RequestBody SkiJumper skiJumper){
        skiJumpersRepository.addJumper(skiJumper);
    }
    @PutMapping("/skiJumpers/{id}")
    public void editSkiJumper(@RequestBody  SkiJumper skiJumper , @PathVariable int id){
        skiJumpersRepository.editJumper(skiJumper , id);
    }
    @DeleteMapping("/skiJumpers/{id}")
        public void deleteSkiJumper(@PathVariable int id){
        skiJumpersRepository.deleteJumper(id);
    }
}

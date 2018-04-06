package pl.mateusz.siwiec.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mateusz.siwiec.SkiJumpersRepository;

@RestController
public class SkiJumpersController {

    SkiJumpersRepository skiJumpersRepository = new SkiJumpersRepository();

}

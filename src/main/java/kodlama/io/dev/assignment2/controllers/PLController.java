package kodlama.io.dev.assignment2.controllers;

import kodlama.io.dev.assignment2.entities.ProgrammingLanguage;
import kodlama.io.dev.assignment2.services.abstracts.PLService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class PLController {
    private PLService plService;

    public PLController(PLService plService){
        this.plService = plService;
    }

    @PostMapping
    public void add(ProgrammingLanguage language){
        plService.add(language);
    }

    @PutMapping
    public void update(ProgrammingLanguage oldLanguage, ProgrammingLanguage newLanguage){
        plService.update(oldLanguage, newLanguage);
    }

    @DeleteMapping
    public void remove(ProgrammingLanguage language){
        plService.remove(language);
    }

    @GetMapping("/printall")
    public void printAll(){
        plService.printAll();
        System.out.println("=========================");
    }

    @GetMapping("/getall")
    public List<ProgrammingLanguage> getAll(){
        return plService.getAll();
    }
}

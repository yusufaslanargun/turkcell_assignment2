package kodlama.io.dev.assignment2.repositories.concretes;

import kodlama.io.dev.assignment2.entities.ProgrammingLanguage;
import kodlama.io.dev.assignment2.repositories.abstracts.PLRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PLRepositoryImpl implements PLRepository {
    private List<ProgrammingLanguage> languageList = new ArrayList<>();

    public PLRepositoryImpl(){
        ProgrammingLanguage language1 = new ProgrammingLanguage("C#", 0, ".cs", "csc");
        ProgrammingLanguage language2 = new ProgrammingLanguage("Java", 1, ".java", "javacc");
        ProgrammingLanguage language3 = new ProgrammingLanguage("C++", 2, ".cpp", "gcc");

        add(language1);
        add(language2);
        add(language3);
    }

    public void add(ProgrammingLanguage language){
        languageList.add(language);
    }

    public void update(ProgrammingLanguage oldLanguage, ProgrammingLanguage newLanguage){
        int index = languageList.indexOf(oldLanguage);
        languageList.set(index, newLanguage);
    }

    public void remove(ProgrammingLanguage language){
        languageList.remove(language);
    }

    public void printAll(){
        for(ProgrammingLanguage language : languageList){
            System.out.println(language.toString());
        }
    }

    public List<ProgrammingLanguage> getAll(){
        return languageList;
    }
}

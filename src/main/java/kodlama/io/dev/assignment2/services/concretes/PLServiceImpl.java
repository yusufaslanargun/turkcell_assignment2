package kodlama.io.dev.assignment2.services.concretes;

import kodlama.io.dev.assignment2.entities.ProgrammingLanguage;
import kodlama.io.dev.assignment2.repositories.abstracts.PLRepository;
import kodlama.io.dev.assignment2.services.abstracts.PLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PLServiceImpl implements PLService {

    private PLRepository plRepository;

    @Autowired
    public PLServiceImpl(PLRepository plRepository){
        this.plRepository = plRepository;
    }

    public void add(ProgrammingLanguage language){
        List<ProgrammingLanguage> languageList = plRepository.getAll();
        boolean isNameConflicts = false;
        boolean isIDConflicts = false;

        for(ProgrammingLanguage lang : languageList){
            if(Objects.equals(language.getName(), lang.getName())){
                isNameConflicts = true;
                break;
            }
            else if(language.getId() == lang.getId()){
                isIDConflicts = true;
                break;
            }
        }
        if(isNameConflicts){
            System.out.println("Bu programlama dili zaten mevcut, tekrar eklenemez.");
        }
        else if(isIDConflicts){
            System.out.println("Bu id ile başka bir programlama dili kayıtlı.");
        }
        else if(isValid(language)){
            System.out.println("Değiştirilecek yeni dil geçerli bir dil değil");
        }
        else{
            plRepository.add(language);
        }
    }

    public void update(ProgrammingLanguage oldLanguage, ProgrammingLanguage newLanguage){
        List<ProgrammingLanguage> languageList = plRepository.getAll();

        if(!languageList.contains(oldLanguage)){
            System.out.println("Güncellenecek dil mevcut değil.");
        }
        else if(isValid(newLanguage)){
            System.out.println("Değiştirilecek yeni dil geçerli bir dil değil");
        }
        else {
            plRepository.update(oldLanguage, newLanguage);
        }
    }

    public void remove(ProgrammingLanguage language){
        plRepository.remove(language);
    }

    public void printAll(){
        plRepository.printAll();
    }

    public List<ProgrammingLanguage> getAll(){
        return plRepository.getAll();
    }

    public boolean isValid(ProgrammingLanguage language){
        if(language.getName().isEmpty() || language.getCompiler().isEmpty() || language.getExtension().isEmpty()){
            System.out.println("Verileri eksiksiz girin.");
            return true;
        }
        return false;
    }
}

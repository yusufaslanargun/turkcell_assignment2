package kodlama.io.dev.assignment2.repositories.abstracts;

import kodlama.io.dev.assignment2.entities.ProgrammingLanguage;

import java.util.List;

public interface PLRepository {
    public void add(ProgrammingLanguage language);
    public void update(ProgrammingLanguage oldLanguage, ProgrammingLanguage newLanguage);
    public void remove(ProgrammingLanguage language);
    public void printAll();
    public List<ProgrammingLanguage> getAll();
}

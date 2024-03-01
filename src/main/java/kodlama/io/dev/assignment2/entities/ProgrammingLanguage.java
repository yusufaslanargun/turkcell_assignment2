package kodlama.io.dev.assignment2.entities;

public class ProgrammingLanguage {
    private String name;
    private int id;
    private String extension;
    private String compiler;

    public ProgrammingLanguage(String name, int id, String extension, String compiler){
        this.name = name;
        this.id = id;
        this.extension = extension;
        this.compiler = compiler;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getCompiler() {
        return compiler;
    }

    public void setCompiler(String compiler) {
        this.compiler = compiler;
    }

    public String toString(){
        return "Language: " + name + "\n" +
                "Language ID: " + id + "\n" +
                "Language File Extension: " + extension + "\n" +
                "Language Compiler: " + compiler + "\n";
    }
}

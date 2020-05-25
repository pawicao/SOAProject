package pl.edu.agh.soa.models;

public class Publication {
    private String name;

    public Publication() {}

    public Publication(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

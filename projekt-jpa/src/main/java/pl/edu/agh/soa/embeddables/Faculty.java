package pl.edu.agh.soa.embeddables;

import javax.persistence.Embeddable;

@Embeddable
public class Faculty {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Faculty() {}

    public Faculty(String name) {
        this.name = name;
    }
}

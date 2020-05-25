package pl.edu.agh.soa.models;

import java.util.HashMap;
import java.util.Map;

public class Organization {
    private String name;
    private int creationYear;

    public Organization() {}

    public Organization(String name, int creationYear) {
        this.name = name;
        this.creationYear = creationYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    static Map<String, Organization> organizations = new HashMap<>();
    public static Organization createOrganization(String name, int creationYear) {
        Organization organization = new Organization(name, creationYear);
        organizations.put(name, organization);
        return organization;
    }
}

package pl.edu.agh.soa.models;

import java.util.HashMap;
import java.util.Map;

public class Dormitory {
    private String name;
    private String code;

    public Dormitory(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public Dormitory() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    static Map<String, Dormitory> dormitories = new HashMap<>();
    public static Dormitory createDormitory(String name, String code) {
        Dormitory dormitory = new Dormitory(name, code);
        dormitories.put(code, dormitory);
        return dormitory;
    }
}

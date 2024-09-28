package org.pojo;

import java.util.ArrayList;

public class EntityData {
    private Integer id;
    private Addition addition;
    private ArrayList<Integer> important_numbers;
    private String title;
    private Boolean verified;

    public EntityData() {
    }

    public EntityData(Addition addition, ArrayList<Integer> important_numbers, String title, Boolean verified) {
        this.addition = addition;
        this.important_numbers = important_numbers;
        this.title = title;
        this.verified = verified;
    }

    public EntityData(Integer id, Addition addition, ArrayList<Integer> important_numbers, String title, Boolean verified) {
        this.id = id;
        this.addition = addition;
        this.important_numbers = important_numbers;
        this.title = title;
        this.verified = verified;
    }

    public Addition getAddition() {
        return addition;
    }

    public ArrayList<Integer> getImportant_numbers() {
        return important_numbers;
    }

    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAddition(Addition addition) {
        this.addition = addition;
    }

    public void setImportant_numbers(ArrayList<Integer> important_numbers) {
        this.important_numbers = important_numbers;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return "CreateEntity{" +
                "id=" + id +
                ", addition=" + addition +
                ", important_numbers=" + important_numbers +
                ", title='" + title + '\'' +
                ", verified=" + verified +
                '}';
    }
}

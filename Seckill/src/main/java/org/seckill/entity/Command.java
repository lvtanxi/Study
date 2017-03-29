package org.seckill.entity;

import java.util.List;

public class Command {
    private Integer id;

    private String name;

    private String description;

    private List<CommandContent> mContents;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public List<CommandContent> getContents() {
        return mContents;
    }

    public void setContents(List<CommandContent> contents) {
        mContents = contents;
    }

    @Override
    public String toString() {
        return "Command{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", mContents=" + mContents +
                '}';
    }
}
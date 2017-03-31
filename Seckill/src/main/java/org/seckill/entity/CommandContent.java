package org.seckill.entity;

public class CommandContent {
    private Integer id;

    private String content;

    private Integer commandId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getCommandId() {
        return commandId;
    }

    public void setCommandId(Integer commandId) {
        this.commandId = commandId;
    }

    @Override
    public String toString() {
        return "CommandContent{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
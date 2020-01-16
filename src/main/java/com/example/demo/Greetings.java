package com.example.demo;

public class Greetings {
    private final long id;
    private final String content;
    public Greetings(long id, String content)
    {
        this.id = id;
        this.content = content;
    }
    public long getId()
    {
        return id;//return this.id;
    }
    public String getContent()
    {
        return content;//return this.name;
    }
}

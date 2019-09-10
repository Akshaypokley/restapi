package com.qa.Data;

public class Users {

    String Name ;
    String Job;
    String id;
    String createdAt;
    Users()
    {

    }
    public Users(String Name,String Job) {
        this.Name = Name;
        this.Job = Job;
    }

    public void setName(String name)
    {
        this.Name=name;
    }

    public String getName()
    {
        return Name;
    }

    public void setJob(String Job)
    {
        this.Job=Job;
    }

    public String getJob()
    {
        return Job;
    }

    public void setId(String id)
    {
        this.id=id;
    }

    public String getid()
    {
        return id;
    }

    public void setcreatedAt(String createdAt)
    {
        this.createdAt=createdAt;
    }

    public String getcreatedAt()
    {
        return createdAt;
    }
}
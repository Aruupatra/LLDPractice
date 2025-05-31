package Swiggy.models;

import java.util.Date;

public abstract class BaseEntity {

    int id;
    Date createdAt;
    Date updatedAt;

    public void setId(int id)
    {
        this.id=id;
    }
}

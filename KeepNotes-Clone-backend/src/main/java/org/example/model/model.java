package org.example.model;

import javax.persistence.Entity;

@Entity
public class model {
    long id;
    String heading;
    String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "model{" +
                "id=" + id +
                ", heading='" + heading + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}

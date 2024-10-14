package org.launchcode.codingevents.models;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.launchcode.codingevents.data.EventData;

import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters.")
    private String name;
    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Location is required.")
    @Size(min = 3, max = 50, message = "Location must be between 3 and 50 characters.")
    private String location;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @AssertTrue(message = "Must be true at this time.")
    private boolean mustRegister;

    public Event(String name, String description, String location, String contactEmail, boolean mustRegister) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.contactEmail = contactEmail;
        this.mustRegister = mustRegister;
        this.id = nextId;
        nextId++;
    }

    public Event() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public @NotBlank(message = "Location is required.") @Size(min = 3, max = 50, message = "Location must be between 3 and 50 characters.") String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank(message = "Location is required.") @Size(min = 3, max = 50, message = "Location must be between 3 and 50 characters.") String location) {
        this.location = location;
    }

    public @Email String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(@Email String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @AssertTrue
    public boolean isMustRegister() {
        return mustRegister;
    }

    public void setMustRegister(@AssertTrue boolean mustRegister) {
        this.mustRegister = mustRegister;
    }

    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}

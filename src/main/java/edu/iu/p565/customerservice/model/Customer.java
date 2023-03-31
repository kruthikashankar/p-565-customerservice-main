//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package edu.iu.p565.customerservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import java.util.Objects;

@Entity
public class Customer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private int id;
    private @NotEmpty(
            message = "name cannot be empty"
    ) String name;
    private @NotEmpty(
            message = "email cannot be empty"
    ) String email;

    public Customer() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Customer)) {
            return false;
        } else {
            Customer customer = (Customer)o;
            return this.id == customer.id && Objects.equals(this.name, customer.name) && Objects.equals(this.email, customer.email);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id, this.name, this.email});
    }
}

package org.example.persist;

public class Customer {
    private Long id;

    private String name;

    private String surname;

    private String address;

    private String phone;

    public Customer() {
    }

    public Customer(Long id, String name, String surname, String address, String phone ) {
        this.id = id;
        this.name = name;
        this.surname  = surname;
        this.address = address;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname ;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSurname(String surname) {
        this.surname  = surname ;
    }
}

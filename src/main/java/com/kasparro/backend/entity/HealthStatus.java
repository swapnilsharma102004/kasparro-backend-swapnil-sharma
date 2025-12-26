package com.kasparro.backend.entity;


import jakarta.persistence.*;

@Entity
@Table(name= "health_status")
public class HealthStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String message;

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public HealthStatus(){

    }
    public HealthStatus(String status,String message){
        this.status=status;
        this.message=message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

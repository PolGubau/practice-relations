package com.polgubau.udemy.relations.practice_relationcs.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "client_details")
public class ClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean vip;

    private Integer points;

    @OneToOne
    private Client client;

    @Override
    public String toString() {
        return "ClientDetails [vip=" + vip + ", points=" + points + "]";
    }

    public ClientDetails() {
    }

    public ClientDetails(boolean vip, Integer points) {
        this.vip = vip;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public Integer getPoints() {
        return points;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}

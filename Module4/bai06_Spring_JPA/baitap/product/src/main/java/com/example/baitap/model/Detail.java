package com.example.baitap.model;

import javax.persistence.*;

@Entity
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_detail")
    private Integer idDetail;
    private String producer;
    private String context;

    @OneToOne(mappedBy = "detail")
    private Product product;

    public Detail() {
    }

    public Integer getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(Integer id_dt) {
        this.idDetail = id_dt;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

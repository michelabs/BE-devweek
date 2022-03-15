package com.dio.devweek.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FaixaEtaria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false, updatable = false)
    private Long id;
    private Integer faixa_i;
    private Integer faixa_n;
    private String descricao;

    public Long getId() {
        return id;
    }

    public Integer getFaixa_i() {
        return faixa_i;
    }

    public void setFaixa_i(Integer faixa_i) {
        this.faixa_i = faixa_i;
    }

    public Integer getFaixa_n() {
        return faixa_n;
    }

    public void setFaixa_n(Integer faixa_n) {
        this.faixa_n = faixa_n;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}

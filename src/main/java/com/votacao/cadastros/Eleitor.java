package com.votacao.cadastros;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Eleitor {
    @Id
    private String cpf;
    private String nome;
    private String inscricao;
    private String zona;
    private String secao;
}

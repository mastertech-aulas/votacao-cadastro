package com.votacao.cadastros;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Eleitor {
    @Id
    private String cpf;
    @NotBlank
    private String nome;
    @NotBlank
    private String inscricao;
    @NotBlank
    private String zona;
    @NotBlank
    private String secao;
}

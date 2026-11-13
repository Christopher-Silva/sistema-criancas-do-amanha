package com.criancasdoamanha;

import com.criancasdoamanha.model.Responsavel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ModeloTeste {

    public static void main(String[] args) {
        Responsavel r = new Responsavel();
        r.setNome("Maria Teste");
        r.setDataNascimento(LocalDate.of(1985, 3, 12));

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println(r.getNome()
                + " | na tela: " + r.getDataNascimento().format(formato)
                + " | no banco: " + r.getDataNascimento());
    }
}
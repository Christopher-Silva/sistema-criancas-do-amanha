package com.criancasdoamanha.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBanco {

    private static final String URL = "jdbc:sqlite:criancas_do_amanha.db";

    private ConexaoBanco() {
    }

    public static Connection getConexao() throws SQLException {
        Connection conexao = DriverManager.getConnection(URL);
        try (Statement stmt = conexao.createStatement()) {
            stmt.execute("PRAGMA foreign_keys = ON");
        }
        return conexao;
    }
}
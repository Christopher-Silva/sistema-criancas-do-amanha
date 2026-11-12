package com.criancasdoamanha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoTeste {

    private static final String URL = "jdbc:sqlite:criancas_do_amanha.db";

    public static void main(String[] args) {
        String sql = """
                SELECT strftime('%Y-%m', mes_referencia) AS mes,
                       ROUND(SUM(CASE WHEN situacao = 'paga' THEN valor ELSE 0 END), 2) AS total_pago,
                       ROUND(SUM(CASE WHEN situacao = 'pendente' THEN valor ELSE 0 END), 2) AS total_pendente,
                       ROUND(SUM(valor), 2) AS total_geral
                FROM Contas
                GROUP BY mes
                ORDER BY mes
                """;

        try (Connection conexao = DriverManager.getConnection(URL);
             Statement stmt = conexao.createStatement()) {

            stmt.execute("PRAGMA foreign_keys = ON");

            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    System.out.println(rs.getString("mes")
                            + " | pago: " + rs.getDouble("total_pago")
                            + " | pendente: " + rs.getDouble("total_pendente")
                            + " | total: " + rs.getDouble("total_geral"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
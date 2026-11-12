package com.criancasdoamanha;

import com.criancasdoamanha.util.ConexaoBanco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoTeste {

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

        try (Connection conexao = ConexaoBanco.getConexao();
             Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getString("mes")
                        + " | pago: " + rs.getDouble("total_pago")
                        + " | pendente: " + rs.getDouble("total_pendente")
                        + " | total: " + rs.getDouble("total_geral"));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
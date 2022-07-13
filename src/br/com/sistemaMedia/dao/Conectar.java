package br.com.sistemaMedia.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {

    public static Connection abrirConexao() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=America/Sao_Paulo&zeroDateTimeBehavior=convertToNull",
                        "root", "Anakim3242");
    }

}

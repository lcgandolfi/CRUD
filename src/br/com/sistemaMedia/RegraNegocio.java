package br.com.sistemaMedia;

public class RegraNegocio {

    public static boolean validarStr(String texto) {

        return texto.length() >= 3;
    }
    
    public static boolean verificarNueroPossitivo(double numero){
        
        return numero > 0;
        
    }

}

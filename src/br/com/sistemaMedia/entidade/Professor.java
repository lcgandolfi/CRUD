package br.com.sistemaMedia.entidade;

public class Professor {

    private Integer id;
    private String nome;
    private Integer qtdAluno;
    private String diciplina;
    private String senha;
    private String usuario;
    private Double mediaPassar;

    public Professor() {
    }

    public Professor(String nome, Integer qtdAluno, String diciplina,
            String senha, String usuario, Double mediaPassar) {
        this.nome = nome;
        this.qtdAluno = qtdAluno;
        this.diciplina = diciplina;
        this.senha = senha;
        this.usuario = usuario;
        this.mediaPassar = mediaPassar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdAluno() {
        return qtdAluno;
    }

    public void setQtdAluno(Integer qtdAluno) {
        this.qtdAluno = qtdAluno;
    }

    public String getDiciplina() {
        return diciplina;
    }

    public void setDiciplina(String diciplina) {
        this.diciplina = diciplina;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Double getMediaPassar() {
        return mediaPassar;
    }

    public void setMediaPassar(Double mediaPassar) {
        this.mediaPassar = mediaPassar;
    }

}

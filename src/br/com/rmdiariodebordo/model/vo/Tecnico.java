package br.com.rmdiariodebordo.model.vo;

/**
 *
 * @author joao.oliveira
 */
public class Tecnico {

    private String nome;
    private String matricula;
    private String supervisor;
    private String setor;
    private String uf;
    private String gra;

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public String getSetor() {
        return setor;
    }

    public String getUf() {
        return uf;
    }

    public String getGra() {
        return gra;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setGra(String gra) {
        this.gra = gra;
    }

}

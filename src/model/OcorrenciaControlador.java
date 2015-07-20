package model;

/**
 *
 * @author joao.oliveira
 */
public class OcorrenciaControlador {

    private String uf;
    private String atendente;
    private String data;
    private String periodo;
    private String tecnico;
    private String setor;
    private String ocorrencia;
    private String recorrenciaSupervisor;
    private String recorrenciaCoordenador;
    private String recorrenciaGerente;
    private String grave;
    private String username;
    private String observacao;

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getUf() {
        return uf;
    }

    public String getAtendente() {
        return atendente;
    }

    public String getData() {
        return data;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getTecnico() {
        return tecnico;
    }

    public String getSetor() {
        return setor;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public String getRecorrenciaSupervisor() {
        return recorrenciaSupervisor;
    }

    public String getRecorrenciaCoordenador() {
        return recorrenciaCoordenador;
    }

    public String getRecorrenciaGerente() {
        return recorrenciaGerente;
    }

    public String getGrave() {
        return grave;
    }

    public String getUsername() {
        return username;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setAtendente(String atendente) {
        this.atendente = atendente;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public void setRecorrenciaSupervisor(String recorrenciaSupervisor) {
        this.recorrenciaSupervisor = recorrenciaSupervisor;
    }

    public void setRecorrenciaCoordenador(String recorrenciaCoordenador) {
        this.recorrenciaCoordenador = recorrenciaCoordenador;
    }

    public void setRecorrenciaGerente(String recorrenciaGerente) {
        this.recorrenciaGerente = recorrenciaGerente;
    }

    public void setGrave(String grave) {
        this.grave = grave;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}

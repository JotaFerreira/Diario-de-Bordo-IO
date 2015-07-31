package br.com.rmdiariodebordo.model.vo;

/**
 *
 * @author joao.oliveira
 */
public class OcorrenciaSupervisor {
    
    private String data_att;
    private String supervisor;
    private String uf;
    private String segmento;
    private String controlador;
    private String ocorrencia;
    private String periodo;
    private String observacao;
    private String username;

    public OcorrenciaSupervisor(String data_att, String supervisor, String uf, String segmento, String controlador, String ocorrencia, String periodo, String observacao, String username) {
        this.data_att = data_att;
        this.supervisor = supervisor;
        this.uf = uf;
        this.segmento = segmento;
        this.controlador = controlador;
        this.ocorrencia = ocorrencia;
        this.periodo = periodo;
        this.observacao = observacao;
        this.username = username;
    }
    
    public OcorrenciaSupervisor(){
        
    }

    public String getData_att() {
        return data_att;
    }

    public void setData_att(String data_att) {
        this.data_att = data_att;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getSegmento() {
        return segmento;
    }

    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    public String getControlador() {
        return controlador;
    }

    public void setControlador(String controlador) {
        this.controlador = controlador;
    }

    public String getOcorrencia() {
        return ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   
    
}

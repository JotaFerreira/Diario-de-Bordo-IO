package br.com.rmdiariodebordo.model.vo;

/**
 *
 * @author joao.oliveira
 */
public final class Ponto {

    private static boolean ativado;
    private static String[] horarios;
    private String nome;
    private String horario1;
    private String horario2;
    private String horario3;
    private String horario4;
    private String horario5;
    private String horario6;
    private String horario7;
    private String horario8;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario1() {
        return horario1;
    }

    public void setHorario1(String horario1) {
        this.horario1 = horario1;
    }

    public String getHorario2() {
        return horario2;
    }

    public void setHorario2(String horario2) {
        this.horario2 = horario2;
    }

    public String getHorario3() {
        return horario3;
    }

    public void setHorario3(String horario3) {
        this.horario3 = horario3;
    }

    public String getHorario4() {
        return horario4;
    }

    public void setHorario4(String horario4) {
        this.horario4 = horario4;
    }

    public String getHorario5() {
        return horario5;
    }

    public void setHorario5(String horario5) {
        this.horario5 = horario5;
    }

    public String getHorario6() {
        return horario6;
    }

    public void setHorario6(String horario6) {
        this.horario6 = horario6;
    }

    public String getHorario7() {
        return horario7;
    }

    public void setHorario7(String horario7) {
        this.horario7 = horario7;
    }

    public String getHorario8() {
        return horario8;
    }

    public void setHorario8(String horario8) {
        this.horario8 = horario8;
    }

    public static boolean isAtivado() {
        return ativado;
    }

    public static void setAtivado(boolean ativado) {
        Ponto.ativado = ativado;
    }

    public static String[] getHorarios() {
        return horarios;
    }

    public static void setHorarios(String[] horarios) {
        Ponto.horarios = horarios;
    }

}

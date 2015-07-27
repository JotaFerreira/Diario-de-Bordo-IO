package lembrete.ponto;

/**
 *
 * @author joao.oliveira
 */
public final class Ponto {
    
    private static boolean ativado;
    private static String[] horarios;

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

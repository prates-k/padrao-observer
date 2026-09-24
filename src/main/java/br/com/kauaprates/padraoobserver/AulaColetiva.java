package br.com.kauaprates.padraoobserver;

import java.util.Observable;

public class AulaColetiva extends Observable {

    private Integer ano;
    private Integer semestre;
    private String nomeModalidade;
    private String nomeTurma;

    public AulaColetiva(Integer ano, Integer semestre, String nomeModalidade, String nomeTurma) {
        this.ano = ano;
        this.semestre = semestre;
        this.nomeModalidade = nomeModalidade;
        this.nomeTurma = nomeTurma;
    }

    public void alterarHorario() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "AulaColetiva{" +
                "ano=" + ano +
                ", semestre=" + semestre +
                ", nomeModalidade='" + nomeModalidade + '\'' +
                ", nomeTurma='" + nomeTurma + '\'' +
                '}';
    }
}

package br.com.kauaprates.padraoobserver;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void deveNotificarUmAluno() {
        AulaColetiva aula = new AulaColetiva(2021, 1, "Yoga", "A");
        Aluno aluno = new Aluno("Aluno 1");
        aluno.matricular(aula);
        aula.alterarHorario();
        assertEquals("Aluno 1, horário alterado na AulaColetiva{ano=2021, semestre=1, nomeModalidade='Yoga', nomeTurma='A'}", aluno.getUltimaNotificacao());
    }

    @Test
    void deveNotificarAlunos() {
        AulaColetiva aula = new AulaColetiva(2021, 1, "Yoga", "A");
        Aluno aluno1 = new Aluno("Aluno 1");
        Aluno aluno2 = new Aluno("Aluno 2");
        aluno1.matricular(aula);
        aluno2.matricular(aula);
        aula.alterarHorario();
        assertEquals("Aluno 1, horário alterado na AulaColetiva{ano=2021, semestre=1, nomeModalidade='Yoga', nomeTurma='A'}", aluno1.getUltimaNotificacao());
        assertEquals("Aluno 2, horário alterado na AulaColetiva{ano=2021, semestre=1, nomeModalidade='Yoga', nomeTurma='A'}", aluno2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarAluno() {
        AulaColetiva aula = new AulaColetiva(2021, 1, "Yoga", "A");
        Aluno aluno = new Aluno("Aluno 1");
        aula.alterarHorario();
        assertEquals(null, aluno.getUltimaNotificacao());
    }

    @Test
    void deveNotificarAlunoTurmaA() {
        AulaColetiva aulaA = new AulaColetiva(2021, 1, "Yoga", "A");
        AulaColetiva aulaB = new AulaColetiva(2021, 1, "Yoga", "B");
        Aluno aluno1 = new Aluno("Aluno 1");
        Aluno aluno2 = new Aluno("Aluno 2");
        aluno1.matricular(aulaA);
        aluno2.matricular(aulaB);
        aulaA.alterarHorario();
        assertEquals("Aluno 1, horário alterado na AulaColetiva{ano=2021, semestre=1, nomeModalidade='Yoga', nomeTurma='A'}", aluno1.getUltimaNotificacao());
        assertEquals(null, aluno2.getUltimaNotificacao());
    }
}

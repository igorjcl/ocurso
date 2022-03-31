/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.igor.ocurso;

import com.igor.ocurso.model.Curso;
import com.igor.ocurso.model.Professor;
import com.igor.ocurso.model.Turma;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author igorj
 */
public class Ocurso {

    private static final Scanner scan = new Scanner(System.in);
    private static final List<Curso> cursos = new ArrayList<>();
    private static final List<Professor> professores = new ArrayList<>();
    private static final List<Turma> turmas = new ArrayList<>();
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");

    public static void main(String[] args) {
        while (true) {
            mostrarMenu();
            System.out.print("escolha: ");
            int escolha = scan.nextInt();

            if (escolha == 0) {
                System.out.println("Volte sempre!!");
                System.exit(0);
            }

            verificarEscolha(escolha);
        }
    }

    private static void verificarEscolha(int escolha) {
        switch (escolha) {
            case 1:
                cadastrarCurso();
                break;
            case 2:
                listarCurso();
                break;
            case 3:
                cadastrarTurma();
                break;
            case 4:
                listarTurmas();
                break;
            case 5:
                cadastrarProfessor();
                break;
            case 6:
                listarProfessor();
                break;
            case 7:
                adicionarTurmaNoCurso();
                break;
            case 8:
                adicionarProfessorNaTurma();
                break;
            default:
                break;
        }
    }

    private static void mostrarMenu() {
        System.out.println("=========== Menu Ocurso ===========\n"
                + "1 - Cadastrar Curso\n"
                + "2 - Listar Curso\n"
                + "3 - Cadastrar Turma\n"
                + "4 - Listar Turmas\n"
                + "5 - Cadastrar Professor\n"
                + "6 - Listar Professores\n"
                + "7 - Adicionar Turma no Curos\n"
                + "8 - Adicionar Professor na Turma"
                + "9 - Sair\n");
    }

    private static void cadastrarCurso() {
        Curso curso = new Curso();

        System.out.println("======== Cadastrar Curso ========\n");
        System.out.println("Nome: ");
        curso.setNome(scan.next());

        System.out.println("Valor do Curso: ");
        curso.setValor(scan.nextDouble());

        System.out.println("Conteudo Programatico");
        curso.setConteudoProgramatico(scan.next());

        System.out.println("Carga Horaria: ");
        curso.setCargaHoraria(scan.nextDouble());
        
        System.out.println("Data inicio (dd/mm/yyyy): ");
        LocalDate dataInicio = LocalDate.parse(scan.next(), dateFormat);
        curso.setDataInicio(dataInicio);
        
        System.out.println("Data inicio (dd/mm/yyyy): ");
        LocalDate dataFim = LocalDate.parse(scan.next(), dateFormat);
        curso.setDataFim(dataFim);
        
        cursos.add(curso);

        System.out.println("======= Curso Cadastrado com sucesso =======\n");
    }

    private static void listarCurso() {
        System.out.println("======== Listar Curso ========\n");
        for (int i = 0; i < cursos.size(); i++) {
            int cursoId = i + 1;
            Curso curso = cursos.get(i);
            System.out.println(
                    cursoId
                    + " - "
                    + curso.getNome()
                    + "\n"
                    + "Carga Horaria: " + curso.getCargaHoraria() + "\n"
                    + "Valor: " + curso.getValor() + "\n"
                    + "Data de Inicio: " + curso.getDataFim().toString() + "\n"
                    + "Data Fim: " + curso.getDataFim().toString() + "\n"
            );
        }
    }
    
    private static void cadastrarTurma() {
        System.out.println("======== Cadastrar Turma ========\n");

        Turma turma = new Turma();

        System.out.println("Nome: ");
        turma.setNome(scan.next());
        
        turmas.add(turma);
    }

    private static void listarTurmas() {
        System.out.println("======== Listar Turmas ========\n");
        for (int i = 0; i < turmas.size(); i++) {
            int turmaId = i + 1;
            Turma turma = turmas.get(i);
            System.out.println(
                    turmaId
                    + " - "
                    + turma.getNome()
                    + "\n"
            );
        }
    }
    
    private static void cadastrarProfessor() {
        Professor professor = new Professor();
        System.out.println("======== Cadastrar Professor ========\n");
        System.out.println("Nome: ");
        professor.setNome(scan.next());
        System.out.println("Email: ");
        professor.setEmail(scan.next());
        System.out.println("Valor por hora: ");
        professor.setValorPorHora(scan.nextDouble());
        
        professores.add(professor);
    }
    
    private static void listarProfessor() {
        System.out.println("======== Listar Professor ========\n");
        for (int i = 0; i < professores.size(); i++) {
            int professorId = i + 1;
            Professor professor = professores.get(i);
            System.out.println(
                    professorId
                    + " - "
                    + professor.getNome()
                    + "\n"
                    + "Email: " + professor.getEmail() + "\n"
            );
        }
    }
    
    private static void adicionarTurmaNoCurso() {
        System.out.println("======== Adicionar Turma no Curso ========\n");
        System.out.println("Informe o id do curso: ");
        int idCurso = scan.nextInt();

        System.out.println("Informe o id da turma: ");
        int idTurma = scan.nextInt();
        
        for (int i = 0; i < cursos.size(); i++) {
            if (i + 1 == idCurso) {
                for (int j = 0; j < turmas.size(); j++) {
                    if (j + 1 == idTurma) {
                        cursos.get(i).getTurmas().add(turmas.get(j));
                    }
                }
            }
        }
    }
    
    private static void adicionarProfessorNaTurma() {
        System.out.println("======== Adicionar Professor na Turma ========\n");
        System.out.println("Informe o id do Professor: ");
        int idProfessor = scan.nextInt();

        System.out.println("Informe o id da Turma: ");
        int idTurma = scan.nextInt();
        
        for (int i = 0; i < turmas.size(); i++) {
            if (i + 1 == idTurma) {
                for (int j = 0; j < professores.size(); j++) {
                    if (j + 1 == idProfessor) {
                        professores.get(j).getTurmas().add(turmas.get(i));
                        turmas.get(i).setProfessor(professores.get(j));
                    }
                }
            }
        }
    }
    
}

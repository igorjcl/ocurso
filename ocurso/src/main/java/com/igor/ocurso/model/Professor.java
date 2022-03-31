/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.igor.ocurso.model;

import java.util.List;

/**
 *
 * @author igorj
 */
public class Professor {
    private String nome;
    private String email;
    private double valorPorHora;
    private List<Turma> turmas;

    public Professor() {
    }

    public Professor(String nome, String email, double valorPorHora, List<Turma> turmas) {
        this.nome = nome;
        this.email = email;
        this.valorPorHora = valorPorHora;
        this.turmas = turmas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}

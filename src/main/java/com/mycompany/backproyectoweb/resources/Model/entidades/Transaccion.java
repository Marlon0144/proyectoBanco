/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.backproyectoweb.resources.Model.entidades;

public class Transaccion {
    private int numberAccountLocal;
    private int numberAccountTarget;
    private int monto;
    private int id;
    private int idUserAccountLocal;
    
    public Transaccion(int idUserAccountLocal, int monto, int numberAccountLocal, int numberAccountTarget) {
        this.idUserAccountLocal = idUserAccountLocal;
        this.monto = monto;
        this.numberAccountLocal = numberAccountLocal;
        this.numberAccountTarget = numberAccountTarget;
    }
    
        public Transaccion(int id, int idUserAccountLocal, int monto, int numberAccountLocal, int numberAccountTarget) {
        this.id = id;
        this.idUserAccountLocal = idUserAccountLocal;
        this.monto = monto;
        this.numberAccountLocal = numberAccountLocal;
        this.numberAccountTarget = numberAccountTarget;
    }

    public int getMonto() {
        return monto;
    }

    public int getIdUserAccountLocal() {
        return idUserAccountLocal;
    }

    public void setIdUserAccountLocal(int idUserAccountLocal) {
        this.idUserAccountLocal = idUserAccountLocal;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getNumberAccountLocal() {
        return numberAccountLocal;
    }

    public void setNumberAccountLocal(int numberAccountLocal) {
        this.numberAccountLocal = numberAccountLocal;
    }

    public int getNumberAccountTarget() {
        return numberAccountTarget;
    }

    public void setNumberAccountReceptor(int numberAccountTarget) {
        this.numberAccountTarget = numberAccountTarget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Transaccion{" + "numberAccountLocal=" + numberAccountLocal + ", numberAccountTarget=" + numberAccountTarget + ", id=" + id + '}';
    }
    
    
}

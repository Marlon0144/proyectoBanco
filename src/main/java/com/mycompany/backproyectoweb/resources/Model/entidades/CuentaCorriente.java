/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.backproyectoweb.resources.Model.entidades;

/**
 *
 * @author ASUS
 */
public class CuentaCorriente extends CuentaBancaria {
    private int deuda;

    public CuentaCorriente(int deuda, int numberAccount, int idUser, int saldo, float interes) {
        super(idUser, saldo, interes);
        this.deuda = 0;
    }

    public int getDeuda() {
        return deuda;
    }

    public void setDeuda(int deuda) {
        this.deuda = deuda;
    }
}

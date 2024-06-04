package com.mycompany.backproyectoweb.resources.Model.entidades;

/**
 *
 * @author ASUS
 */
public class CuentaBancaria {
    private int numberAccount;
    private int idUser;
    private double saldo;
    private double interes;

    public CuentaBancaria(int numberAccount, int idUser, double saldo, double interes) {
        this.numberAccount = numberAccount;
        this.idUser = idUser;
        this.saldo = saldo;
        this.interes = interes;
    }
    
    public CuentaBancaria(int idUser, double saldo, double interes) {
        this.idUser = idUser;
        this.saldo = saldo;
        this.interes = interes;
    }
    
    public CuentaBancaria(int idUser) {
        this.idUser = idUser;
        this.saldo = 0;
        this.interes = 0;
    }
    
    public CuentaBancaria(int idUser, double saldo) {
        this.idUser = idUser;
        this.saldo = saldo;
        this.interes = 0;
    }

    public int getNumberAccount() {
        return numberAccount;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + "numberAccount=" + numberAccount + ", idUser=" + idUser + ", saldo=" + saldo + ", interes=" + interes + '}';
    }
    
    

    
    
}

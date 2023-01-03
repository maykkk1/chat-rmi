/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author maycondouglas
 */
public class ClienteMain {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
            new TelaLogin().setVisible(true);
    }
}

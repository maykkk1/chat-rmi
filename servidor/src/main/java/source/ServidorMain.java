/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 *
 * @author maycondouglas
 */
public class ServidorMain {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        // Cria a refência remota do servidor
        LocateRegistry.createRegistry(4322);
        Naming.rebind("rmi://localhost:4322/remote", new Servidor());  
    }
}

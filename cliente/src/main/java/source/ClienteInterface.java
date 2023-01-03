/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package source;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author maycondouglas
 */
public interface ClienteInterface extends Remote {
    void receberMensagem(String mensagem) throws RemoteException;
    String getNomeCliente() throws RemoteException;
}

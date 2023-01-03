/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package source;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author maycondouglas
 */
public interface ServidorInterface extends Remote {
    void registrarCliente(ClienteInterface cliente) throws RemoteException;
    void removerCliente(ClienteInterface cliente) throws RemoteException; 
    void repassarMensagem(String mensagem) throws RemoteException;
    ArrayList<String> getClientesPeloNome() throws RemoteException;
    boolean checaSeNomeExiste(String nome) throws RemoteException;
}

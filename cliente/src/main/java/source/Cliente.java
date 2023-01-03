/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author maycondouglas
 */
public class Cliente extends UnicastRemoteObject implements ClienteInterface, Runnable {
    public ServidorInterface servidor;
    private String name;
    private JTextArea chatOutput;
    
    public Cliente(ServidorInterface servidor, String name) throws RemoteException {
        this.servidor = servidor;
        this.name = name;
        this.servidor.registrarCliente(this);
    }
    
    public ServidorInterface getServidor(){
        return this.servidor;
    }
    
    // Método responsável por receber mensagens enviadas por outros clientes do servidor
    @Override
    public void receberMensagem(String mensagem) throws RemoteException {
        this.chatOutput.setText(this.chatOutput.getText()+"\n"+mensagem);
    }
    
    @Override
    public String getNomeCliente() throws RemoteException {
        return this.name;
    }
    
    // Método responsável por pegar a referência do Jtext(mensagens enviadas) da TelaChat
    public void setChatOutput(JTextArea chatOutput) {
        this.chatOutput = chatOutput;
    }

    // Método responsável por executar o cliente e a TelaChat em uma nova thread
    @Override
    public void run() {
        try {
            new TelaChat(this).setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package source;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author maycondouglas
 */
public class Servidor extends UnicastRemoteObject implements ServidorInterface {
    private final ArrayList<ClienteInterface> clientes;
    
    public Servidor() throws RemoteException {
        super();
        this.clientes = new ArrayList<ClienteInterface>();
        System.out.println("O servidor conectou.");
    }

    // Método responsável por adicionar um cliente na lista de clientes conectados
    public synchronized void registrarCliente(ClienteInterface cliente) throws RemoteException {
        this.clientes.add(cliente);
        System.out.println("O cliente "+cliente.getNomeCliente()+" conectou!");
    }

    // Método responsável por transmitir mensagem para todos os clientes conectados
    public synchronized void repassarMensagem(String mensagem) throws RemoteException {
        for(ClienteInterface Icliente: this.clientes) {
            Icliente.receberMensagem(mensagem);
        }
    }

    
    // Método responsável retornar um array com os nomes dos clientes conectados
    @Override
    public synchronized ArrayList<String> getClientesPeloNome() throws RemoteException {
        ArrayList<String> clientesNomes = new ArrayList<String>();
        for(ClienteInterface Icliente: this.clientes) {
            clientesNomes.add(Icliente.getNomeCliente());
        }
        return clientesNomes;
    }

    
    // Método responsável por validar se o nome do cliente informado já existe
    @Override
    public boolean checaSeNomeExiste(String nome) throws RemoteException {
        ArrayList<String> listaDeClientes = this.getClientesPeloNome();
        for(ClienteInterface Icliente: this.clientes) {
            if(Icliente.getNomeCliente().toLowerCase().equals(nome.toLowerCase())) return true;
        }
        return false;
    }

    // Método responsável por remover um cliente
    @Override
    public void removerCliente(ClienteInterface cliente) throws RemoteException {
        this.clientes.remove(cliente);
    }
}

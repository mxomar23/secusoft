/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author dec0d
 */
public class MainServer {
    public static void main(String[] args) {
        try {
            Registry miRegistro = LocateRegistry.createRegistry(1234);
            miRegistro.rebind("SE", new ServerImplements());
            System.out.println("Server On");
        } catch (Exception e) {
        }
    }
}

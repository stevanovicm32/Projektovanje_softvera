/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Lenovo
 */
public class ServerskaNit extends Thread{
    private ServerSocket serverSocket;
    
    public ServerskaNit(){
        try{
            serverSocket=new ServerSocket(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            while(!serverSocket.isClosed()){
                System.out.println("Cekanje klijenta...");
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao!");
                KlijentskaNit th = new KlijentskaNit(socket);
                th.start();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public ServerSocket getServerSocket(){
        return serverSocket;
    }
    
    public void setServerSocket(ServerSocket serverSocket){
        this.serverSocket=serverSocket;
    }
}

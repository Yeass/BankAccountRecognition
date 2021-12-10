package com.company;
import java.io.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException{
	// write your code here
        URL url = new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Proszę o podanie trzech pierwszych cyfr konta bankowego: ");
        String inputString = br.readLine();

        try(BufferedReader ur = new BufferedReader(new InputStreamReader(url.openStream()))){
            String line;
            System.out.println("Odczytuje dane z pliku...");
            while ((line = ur.readLine()) != null){
                String[] words = line.split("\\t+");
                String bankNumber = words[0].trim();
                String bankName = words[1].trim();
                if(bankNumber.equals(inputString)) {
                    System.out.println("Numer banku : " + bankNumber + "\nNazwa Twojego banku to: " + bankName);
                    break;
                }
            }
        }catch (IOException e){
            System.out.println("Błąd wczytania danych");
        }
    }
}

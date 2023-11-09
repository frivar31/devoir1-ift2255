import Data.Entities.Products.Product;
import Data.Entities.Users.Client;
import Data.Entities.Users.Seller;
import Utils.PrintUtil;

import java.util.*;

public class Driver {
    public static void main(String[] args) {

        Product product1=new Product("title","desc","cat",new Date(2023,11,01),5,1,1);
        System.out.println(product1.getId());
        Product product2=new Product("title","desc","cat",new Date(2023,11,01),5,1,1);
        System.out.println(product2.getId());
        Product product3=new Product("title","desc","cat",new Date(2023,11,01),5,1,1);
        Seller seller=new Seller("olivier","dery","o@o.com","zupooli",514l,new ArrayList<Product>(Arrays.asList(product1,product2,product3)));
        System.out.println(seller);
        PrintUtil.welcomeMessage("Bienvenue dans la Plateforme Unishop !!!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choisissez une option: ");
        System.out.println("1. S'inscrire");
        System.out.println("2. Se connecter") ;
        int option = -1 ;
        try {
            option = scanner.nextInt();

        } catch (InputMismatchException e) {
            System.err.println("Ooops! option doit etre chiffre 1 ou 2");
        }
        if (option == 1) {
            System.out.println("Choisissez une option d'inscription");
            System.out.println("1. Vendeur");
            System.out.println("2. Acheteur");
            try {
                option = scanner.nextInt();
            }
            catch (InputMismatchException e) {
                System.err.println("Ooops! option d'inscription doit etre chiffre 1 ou 2");
            }
            if (option == 2) {
                scanner = new Scanner(System.in);
                System.out.print("Saisissez votre Prenom: ");
                String firstName = "";
                try {
                    firstName = scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Ooops! prenom doit etre une chaine de caracteres");
                }

                System.out.print("Saisissez votre nom: ");
                String lastName = null ;
                try {
                    lastName = scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Ooops! nom doit etre une chaine de caracteres");
                }


                System.out.print("Saisissez votre pseudo: ");
                String pseudo = null;
                try {
                    pseudo = scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Ooops! pseudo doit etre une chaine de caracteres");
                }

                System.out.print("Saisissez votre email: ");
                String email = null;
                try {
                    email = scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Ooops! email doit etre une chaine de caracteres");
                }

                scanner = new Scanner(System.in);
                System.out.print("Saisissez votre numero: ");
                long number = 0;
                try {
                    number = scanner.nextLong();
                } catch (InputMismatchException e) {
                    System.err.println("Ooops! numero doit etre un nombre");
                }

                scanner = new Scanner(System.in);
                System.out.print("Saisissez votre adresse de livraison: ");
                String shipAddress = null;
                try {
                    shipAddress = scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Ooops! adresse de livraison doit etre une chaine de caractere");
                }
            }

        }


    }
}
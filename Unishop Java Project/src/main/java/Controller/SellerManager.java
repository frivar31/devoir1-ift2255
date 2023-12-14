package Controller;

import Data.Entities.Catalog;
import Data.Entities.Products.Product;
import Data.Entities.Products.ProductType;
import Data.Entities.Users.Client;
import Data.Entities.Users.Seller;
import Data.Entities.Users.User;
import Service.UserInteractionService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SellerManager {
    public UserInteractionService input;
    private ProductManager productManager;
    private ClientManager clientManager;
    private List<Seller> sellers;

    public SellerManager(List<Seller> sellers) {
        this.sellers = sellers;
        this.input = new UserInteractionService();
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(ArrayList<Seller> sellers) {
        this.sellers = sellers;
    }

    public void setClientManager(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public boolean isPseudoAlreadyUsed(String pseudo) {
        for (Client client : clientManager.getClients()) {
            if(client.getPseudo().equals(pseudo)) return true ;
        }
        return sellers.stream().anyMatch(user -> pseudo.equals(user.getPseudo()));
    }

    public List<Seller> findSellersByName() {
        List<Seller> sellers = new ArrayList<>();
        while(sellers.isEmpty()) {
            System.out.println("Entrer le nom du vendeur");
            String name = input.getUserStrInfo("Nom") ;
            for (Seller seller : this.sellers) {
                if (seller.getFirstName().equals(name)) sellers.add(seller) ;
            }
            if (sellers.isEmpty()) System.out.println("Vendeurs de nom: "+name+" indisponible. Veuillez reessayer svp");
        }

        return sellers ;
    }

    /*public List<Seller> findSellersByAdress() {
        List<Seller> sellers = new ArrayList<>() ;
        while(sellers.isEmpty()) {
            System.out.println("Entrer l'adresse du vendeur") ;
            String address = input.getUserStrInfo("Adresse") ;
            for (Seller seller : this.sellers) {
                if(seller.getA)
            }
        }
        return null ; //TODO
    }*/



    public List<Seller> findSellersByProductType() {
        List<Seller> sellers = new ArrayList<>() ;
        System.out.println("Entrer la catégorie du produit vendu par le vendeur");
        System.out.println("1. Livres et Manuels");
        System.out.println("2. Ressource d'apprentissage");
        System.out.println("3. Article de papeterie");
        System.out.println("4. Materiel informatique");
        System.out.println("5. Equipement de bureau");
        int option = input.getOption(1,5) ;
        switch (option) {
            case 1:
                while(sellers.isEmpty()) {
                    sellers = this.sellers.stream().filter(seller -> seller.getProducts().stream().anyMatch(product -> product.getCategory().equals(ProductType.Book))).collect(Collectors.toList());
                    if (sellers.isEmpty()) System.out.println("Vendeurs avec categorie: "+ProductType.Book+" indisponible. Veuillez reessayer svp");
                }
                break;
            case 2:
                while(sellers.isEmpty()) {
                    sellers = this.sellers.stream().filter(seller -> seller.getProducts().stream().anyMatch(product -> product.getCategory().equals(ProductType.LearningResource))).collect(Collectors.toList());
                    if (sellers.isEmpty()) System.out.println("Vendeurs avec categorie: "+ProductType.LearningResource+" indisponible. Veuillez reessayer svp");
                }
                break;
            case 3:
                while(sellers.isEmpty()) {
                    sellers = this.sellers.stream().filter(seller -> seller.getProducts().stream().anyMatch(product -> product.getCategory().equals(ProductType.Article))).collect(Collectors.toList());
                    if (sellers.isEmpty()) System.out.println("Vendeurs avec categorie: "+ProductType.Article+" indisponible. Veuillez reessayer svp");
                }
                break;
            case 4:
                while(sellers.isEmpty()) {
                    sellers = this.sellers.stream().filter(seller -> seller.getProducts().stream().anyMatch(product -> product.getCategory().equals(ProductType.Hardware))).collect(Collectors.toList());
                    if (sellers.isEmpty()) System.out.println("Vendeurs avec categorie: "+ProductType.Hardware+" indisponible. Veuillez reessayer svp");
                }
                break;
            case 5:
                while(sellers.isEmpty()) {
                    sellers = this.sellers.stream().filter(seller -> seller.getProducts().stream().anyMatch(product -> product.getCategory().equals(ProductType.DesktopTool))).collect(Collectors.toList());
                    if (sellers.isEmpty()) System.out.println("Vendeurs avec categorie: "+ProductType.DesktopTool+" indisponible. Veuillez reessayer svp");
                }
                break;
        }
        return sellers ;
    }

    public boolean getSellerServiceInfo(Seller seller) {

        boolean repeat = true ;
        while(repeat) {
            System.out.println("Selectionner la tache que vous voulez effectuer: ");
            System.out.println("1. Offrir un produit: ");
            System.out.println("2. Changer l'etat d'une commande: ");
            System.out.println("3. Modifier son profile");
            System.out.println("4. Quitter");
            int option = input.getOption(1, 4);
            switch (option) {
                case 1:
                    Product product = null;
                    product = productManager.getProductInfo();
                    seller.addProduct(product);
                    break;
                case 3:
                    boolean redo = true;
                    while (redo) {
                        modifySellerInfo(seller);
                        System.out.println(seller);
                        System.out.println("Confirmer vos informations: ");
                        System.out.println("1. oui");
                        System.out.println("2. non");
                        System.out.println();
                        option = input.getOption(1, 2);
                        if (option == 1) {
                            redo = false;
                            System.out.println("votre compte a ete modifie avec succes");
                        }
                    }
                case 4:
                    System.out.println("Merci d'avoir utilisé notre service. Au revoir!") ;
                    repeat = false ;
                    return repeat ;
            }
        }
        return !repeat ;
    }

    public void modifySellerInfo(Seller seller) {
        System.out.println("Choisir information a modifier: ");
        System.out.println("1. Prenom");
        System.out.println("2. Nom");
        System.out.println("3. Email");
        System.out.println("4. Pseudo");
        System.out.println("5. Numero");
        System.out.println("6. Mot de passe");

        int option = input.getOption(1, 6);

        switch (option) {
            case 1:
                seller.setFirstName(input.getUserStrInfo("Prenom"));
                break;
            case 2:
                seller.setLastName(input.getUserStrInfo("Nom"));
                break;
            case 3:
                String email = input.getUserStrInfo("Email");
                while (isEmailAlreadyUsed(email)) {
                    System.out.println("Cet email est déjà utilisé. Veuillez entrer un nouveau.");
                    email = input.getUserStrInfo("email");
                }
                seller.setEmail(email);
                break;
            case 4:
                String pseudo = input.getUserStrInfo("pseudo");
                while (isPseudoAlreadyUsed(pseudo)) {
                    System.out.println("Ce pseudo est déjà utilisé. Veuillez entrer un nouveau.");
                    pseudo = input.getUserStrInfo("pseudo");
                }
                seller.setPseudo(pseudo);
                break;
            case 5:
                seller.setNumber(input.getUserNumInfo("Numero", 1, Integer.MAX_VALUE));
                break;
            case 6:
                String password = input.getUserStrInfo("Mot de passe");
                while (isPasswordAlreadyUsed(password)) {
                    System.out.println("Ce mot de passe est déjà utilisé. Veuillez entrer un nouveau.");
                    password = input.getUserStrInfo("Mot de passe");
                }
                seller.setPseudo(password);
                break;
            default:
                System.out.println("option doit etre compris entre 1 et 5");
                break;
        }
    }

    public User getUserByPseudo(String pseudo) {
        return sellers.stream().filter(u -> pseudo.equals(u.getPseudo())).findAny().orElse(null);
    }

    public Seller getSellerRegistrationInfo() {
        System.out.println("Vous devez offrir au moins un produit à vendre au prealable");
        System.out.println("1. Offrir un produit à vendre:");
        Product product = null;

        if (input.getOption(1, 1) == 1) {
            product = productManager.getProductInfo();
        }
        System.out.println("Saisissez vos informations");

        String firstName = input.getUserStrInfo("Prenom");
        String lastName = input.getUserStrInfo("Nom");
        String email = input.getUserStrInfo("Email");

        while (isEmailAlreadyUsed(email)) {
            System.out.println("Cet email est déjà utilisé. Veuillez entrer un nouveau.");
            email = input.getUserStrInfo("Email");
        }

        String pseudo = input.getUserStrInfo("pseudo");

        while (isPseudoAlreadyUsed(pseudo)) {
            System.out.println("Ce pseudo est déjà utilisé. Veuillez entrer un nouveau.");
            pseudo = input.getUserStrInfo("pseudo");
        }

        long number = input.getUserNumInfo("Numero", 1, Integer.MAX_VALUE);

        String password = input.getUserStrInfo("Mot de passe") ;
        while (isPasswordAlreadyUsed(password)) {
            System.out.println("Ce mot de passe est déjà utilisé. Veuillez entrer un nouveau.");
            password = input.getUserStrInfo("Mot de passe");
        }

        ArrayList<Product> products = new ArrayList<>();
        products.add(product);
        Seller seller = new Seller(firstName, lastName, email, pseudo, number, products,password);

        int option = 2;
        while (option == 2) {
            System.out.println(seller);
            System.out.println("Confirmer vos informations: ");
            System.out.println("1. oui");
            System.out.println("2. non");
            System.out.println();
            option = input.getOption(1, 2);
            if (option == 1) {
                System.out.println("votre compte a ete cree avec succes");
            } else {
                System.out.println("Voulez vous modifier vos informations:  ");
                System.out.println("1. oui");
                System.out.println("2. non");
                System.out.println();

                if (input.getOption(1, 2) == 1) {
                    modifySellerInfo(seller);
                }
                option = 2;
            }
        }
        return seller;
    }

    public boolean isEmailAlreadyUsed(String email) {
        for (Client client : clientManager.getClients()) {
            if(client.getEmail().equals(email)) return true ;
        }
        return sellers.stream().anyMatch(user -> email.equals(user.getEmail()));
    }

    public boolean isPasswordAlreadyUsed(String password) {
        for (Client client : clientManager.getClients()) {
            if(client.getPassword().equals(password)) return true ;
        }
        return sellers.stream().anyMatch(user -> password.equals(user.getPassword()));
    }
    public void test(){
        sellers.stream().filter(seller -> seller.getProducts().stream().anyMatch(product -> product.getCategory().equals(ProductType.Book))).collect(Collectors.toList());
    }
}

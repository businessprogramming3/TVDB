/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TVShow.viewui;

import TVShow.datastore.mysql.TVShowDAO;
import TVShow.model.ITVShowDAO;
import TVShow.model.TVShow;
import TVShow.util.Validator;
import java.util.Scanner;

/**
 *
 * @author jacqu_000
 */
public class TVShowApp {
   


    ITVShowDAO TVShowList = new TVShowDAO();
    Scanner sc = new Scanner(System.in);

    public TVShowApp() {
        menuLoop();
    }

    private void menuLoop() {
        int id;
        String Writer, Genera, DirectorsName;
        double rating;
        String choice = "1";
        while (!choice.equals("0")) {
            System.out.println("\nTVShowApp");
            System.out.println("0 = Quit");
            System.out.println("1 = List All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Record");
            System.out.println("4 = Update Record");
            System.out.println("5 = Delete Record");
            choice = Validator.getLine(sc, "Number of choice: ", "^[0-5]$");

            switch (choice) {
                case "1":
                    System.out.println(TVShowList.toString());
                    break;
                case "2":
                    id = Validator.getInt(sc, "TV Show ID; ");
                    Writer = Validator.getLine(sc, "Write: ");
                    Genera = Validator.getLine(sc, "Genera: ");
                    DirectorsName = Validator.getLine(sc, "DirectorsName: ");
                    rating = Validator.getDouble(sc, "Rating: ");
                    TVShowList.createRecord(new TVShow(id, Genera, DirectorsName, rating, Writer));
                    break;
                case "3":
                    id = Validator.getInt(sc, "Movie ID to retrieve: ");
                    System.out.println(TVShowList.retrieveRecordById(id));
                    break;
                case "4":
                    id = Validator.getInt(sc, "Movie ID to update: ");
                    Writer = Validator.getLine(sc, "Writer : ");
                    Genera = Validator.getLine(sc, "Genera: ");
                    DirectorsName = Validator.getLine(sc, "DirectorsName: ");
                    rating = Validator.getDouble(sc, "Rating: ");
                    TVShow updateTVshow = new TVShow(id, Genera, DirectorsName, rating, Writer);
                    TVShowList.updateRecord(updateTVshow);
                    break;
                case "5":
                    id = Validator.getInt(sc, "Employee ID to delete: ");
                    System.out.println(TVShowList.retrieveRecordById(id));
                    String ok = Validator.getLine(sc, "Delete this record? (y/n) ", "^[yYnN]$");
                    if (ok.equalsIgnoreCase("Y")) {
                        TVShowList.deleteRecord(id);
                    }
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new TVShowApp();
    }
}



package gov.iti.jets.filmslibrary;

import gov.iti.jets.filmslibrary.services.ActorFilmsService;

public class Main {
    public static void main(String args[]) {
            System.out.println(new ActorFilmsService().getFilmsOFAnActor((short) 1).getFilms().get(0));

    }
}

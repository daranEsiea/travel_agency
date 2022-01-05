package fr.lernejo.travelsite;

public class TravelService {
    public void inscription(User user) throws InvalidInscriptionException{
        Boolean inscription = user.isValidInscription();
        if(!inscription) throw new InvalidInscriptionException();
    }
}

package klassen;

/**
 * Created by bart-_000 on 3-3-2017.
 */
public class Monteur {
    //Replace inheritance with delegation
    private final MyPerson person = new MyPerson();
  //  private String naam;
    private Auto auto;


    public Monteur(Auto auto){
        this.auto = auto;
    }

    public Auto getAuto(){
        return person.getAuto();
    }

    public String getName() {
        return person.getName();
    }

    private class MyPerson extends Person {
    }
}

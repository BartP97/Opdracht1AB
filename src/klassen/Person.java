package klassen;

/**
 * Created by bart-_000 on 3-3-2017.
 */
public abstract class Person {
    private String name;
    private Auto auto;
public Person(){

}
    public Person(String name, Auto auto){
        this.name = name;
        this.auto = auto;
    }
    public String getName(){
        return name;
    }
    public Auto getAuto(){
        return auto;
    }
}

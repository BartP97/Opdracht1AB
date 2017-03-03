package klassen;

public class AutoBuilder {
    private String typeNaam;
    private String kenteken;

    public AutoBuilder setTypeNaam(String typeNaam) {
        this.typeNaam = typeNaam;
        return this;
    }

    public AutoBuilder setKenteken(String kenteken) {
        this.kenteken = kenteken;
        return this;
    }

    public Auto createAuto() {
        return new Auto(typeNaam, kenteken);
    }
}
package klassen;

public class CalculationValues {
    private final double kort;
    private final double brand;
    private final double ond;
    private final double man;

    public CalculationValues(double kort, double brand, double ond, double man) {
        this.kort = kort;
        this.brand = brand;
        this.ond = ond;
        this.man = man;
    }

    public double getKort() {
        return kort;
    }

    public double getBrand() {
        return brand;
    }

    public double getOnd() {
        return ond;
    }

    public double getMan() {
        return man;
    }
}

// The StateTotals class stores the running total population, total child population, and total child poverty population
// for a state code with getter methods provided.  The method addToStateTotals updates the running totals with the populations
// that are passed in.

public class StateTotals {
    private int stateCode;
    private int totalPopulation;
    private int totalChildPopulation;
    private int totalChildPovertyPopulation;

    // Parameterized constructor that initializes the state code, total population, total child population, and total
    // child poverty population.
    public StateTotals(int stateCode, int totalPopulation, int totalChildPopulation, int totalChildPovertyPopulation) {
        this.stateCode = stateCode;
        this.totalPopulation = totalPopulation;
        this.totalChildPopulation = totalChildPopulation;
        this.totalChildPovertyPopulation = totalChildPovertyPopulation;
    }

    // Getter method to read the state code attribute.
    public int getStateCode() {
        return stateCode;
    }

    // Getter method to read the total population attribute.
    public int getTotalPopulation() {
        return totalPopulation;
    }

    // Getter method to read the total child population attribute.
    public int getTotalChildPopulation() {
        return totalChildPopulation;
    }

    // Getter method to read the total child poverty population.
    public int getTotalChildPovertyPopulation() {
        return totalChildPovertyPopulation;
    }

    // addToStateTotals method adds the provided district population, district child population, and district child poverty
    // population to the running totals for this state code.
    public void addToStateTotals(int districtPopulation,
                                 int districtChildPopulation,
                                 int districtChildPovertyPopulation) {
        this.totalPopulation += districtPopulation;
        this.totalChildPopulation += districtChildPopulation;
        this.totalChildPovertyPopulation += districtChildPovertyPopulation;
    }

    // Determines if two StateTotals objects are equals by comparing whether their stateCodes are equal.
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StateTotals)) {
            return false;
        }
        StateTotals stateTotals = (StateTotals)obj;
        return stateTotals.getStateCode() == this.getStateCode();
    }
 }
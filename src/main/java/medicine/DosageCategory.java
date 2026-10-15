package medicine;

/**
 * Enum representing different dosage categories with their corresponding milligram values.
 */
public enum DosageCategory {
    Low(10),
    Medium(20),
    High(30);

    /**
     * The milligram value associated with each dosage category.
     */
    private int mg;

    public int getMg() {
        return this.mg;
    }

    DosageCategory(int mg) {
        this.mg = mg;
    }
}

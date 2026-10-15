package medicine;

/**
 * This interface represents a medicine with methods to get the weight of the active ingredient and its concentration category.
 */
public interface Medicine {
    /**
     * Returns the weight of the active ingredient in the medicine.
     *
     * @return the weight of the active ingredient
     */
    int getWeightOfActiveIngredient();
    /**
     * Returns the concentration category of the medicine.
     *
     * @return the concentration category depending on the weight of its active ingredient:
     *         "Low", "Medium", "High" or "Invalid Concentration".
     */
    String getConcentrationCategory();


}

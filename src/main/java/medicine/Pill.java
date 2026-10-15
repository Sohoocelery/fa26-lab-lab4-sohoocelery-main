package medicine;

/**
 * This class represents medicine in pill form.
 */
public class Pill implements Medicine {
  private final int weightOfActiveIngredient;

  /**
   * Constructs a Pill with the specified weight of active ingredient.
   *
   * @param weightOfActiveIngredient the weight of the active ingredient in mg
   * @throws IllegalArgumentException if the weight is negative
   */
  public Pill(int weightOfActiveIngredient) {
    if (weightOfActiveIngredient < 0) {
      throw new IllegalArgumentException("Weight cannot be negative.");
    }
    this.weightOfActiveIngredient = weightOfActiveIngredient;
  }

  @Override
  public int getWeightOfActiveIngredient() {
    return this.weightOfActiveIngredient;
  }

  @Override
  public String getConcentrationCategory() {
    int w = this.weightOfActiveIngredient;
    if (Math.abs(w - DosageCategory.Low.getMg()) <= 2) {
      return "Low";
    } else if (Math.abs(w - DosageCategory.Medium.getMg()) <= 2) {
      return "Medium";
    } else if (Math.abs(w - DosageCategory.High.getMg()) <= 2) {
      return "High";
    }
    return "Invalid Concentration";
  }

  /*
   * // Part 1 Equality and HashCode implementation (tolerance-based)
   * @Override
   * public boolean equals(Object obj) {
   *   if (this == obj) {
   *     return true;
   *   }
   *   if (!(obj instanceof Medicine)) {
   *     return false;
   *   }
   *   Medicine other = (Medicine) obj;
   *   return Math.abs(this.getWeightOfActiveIngredient() - other.getWeightOfActiveIngredient()) <= 2;
   * }
   *
   * @Override
   * public int hashCode() {
   *   return Integer.hashCode(this.weightOfActiveIngredient / 5);
   * }
   */

  // Part 2 Equality and HashCode implementation (zone/interval-based)
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Medicine)) {
      return false;
    }
    Medicine other = (Medicine) obj;
    return getSafeConcentrationZone(this.weightOfActiveIngredient)
        == getSafeConcentrationZone(other.getWeightOfActiveIngredient());
  }

  @Override
  public int hashCode() {
    return Integer.hashCode(getSafeConcentrationZone(this.weightOfActiveIngredient));
  }

  private int getSafeConcentrationZone(int w) {
    if (w < 8) {
      return 1;
    }
    if (w <= 12) {
      return 2; // Safe Low zone [8, 12]
    }
    if (w < 18) {
      return 3; // Between Low and Medium (13-17)
    }
    if (w <= 22) {
      return 4; // Safe Medium zone [18, 22]
    }
    if (w < 28) {
      return 5; // Between Medium and High (23-27)
    }
    if (w <= 32) {
      return 6; // Safe High zone [28, 32]
    }
    return 7;
  }
}
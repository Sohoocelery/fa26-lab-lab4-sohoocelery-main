package medicine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for Pill and Syrup implementations of the Medicine interface.
 */
public class MedicineTest {

  @Test
  public void testPillConstructorAndGetters() {
    Pill pill = new Pill(10);
    assertEquals(10, pill.getWeightOfActiveIngredient());
    assertEquals("Low", pill.getConcentrationCategory());
  }

  @Test
  public void testPillNegativeWeightThrowsException() {
    assertThrows(IllegalArgumentException.class, () -> new Pill(-5));
  }

  @Test
  public void testSyrupConstructorAndGetters() {
    Syrup syrup = new Syrup(5, 4); // 20mg -> Medium
    assertEquals(20, syrup.getWeightOfActiveIngredient());
    assertEquals("Medium", syrup.getConcentrationCategory());
  }

  @Test
  public void testSyrupNegativeParametersThrowException() {
    assertThrows(IllegalArgumentException.class, () -> new Syrup(-5, 4));
    assertThrows(IllegalArgumentException.class, () -> new Syrup(5, -4));
  }

  @Test
  public void testConcentrationCategories() {
    assertEquals("Low", new Pill(8).getConcentrationCategory());
    assertEquals("Low", new Pill(12).getConcentrationCategory());
    assertEquals("Medium", new Pill(18).getConcentrationCategory());
    assertEquals("Medium", new Pill(22).getConcentrationCategory());
    assertEquals("High", new Pill(28).getConcentrationCategory());
    assertEquals("High", new Pill(32).getConcentrationCategory());
    assertEquals("Invalid Concentration", new Pill(15).getConcentrationCategory());
  }

  @Test
  public void testEqualityAndHashCode() {
    Medicine p1 = new Pill(10);
    Medicine p2 = new Pill(12);
    Medicine s1 = new Syrup(3, 4); // 12mg

    assertTrue(p1.equals(p2));
    assertTrue(p1.equals(s1));
    assertEquals(p1.hashCode(), p2.hashCode());
    assertEquals(p1.hashCode(), s1.hashCode());
  }
}
package com.dicetool;

import java.util.List;

/**
 * Immutable result of a dice roll.
 *
 * @param numDice  number of dice rolled (N)
 * @param sides    number of sides per die (X)
 * @param modifier flat modifier applied to the total (M)
 * @param rolls    individual die results
 * @param total    sum of all rolls + modifier
 */
public record RollResult(
    int numDice,
    int sides,
    int modifier,
    List<Integer> rolls,
    int total) {
  @Override
  public String toString() {
    String mod = modifier > 0 ? "+" + modifier
        : modifier < 0 ? String.valueOf(modifier)
            : "";
    return String.format("%dd%d%s -> %s -> %d",
        numDice, sides, mod, rolls, total);
  }
}

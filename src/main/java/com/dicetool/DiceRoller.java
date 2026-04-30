package com.dicetool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Core dice engine. Rolls N dice of X sides with an optional modifier.
 * Accepts an injected Random for testability.
 */
public class DiceRoller {

  private final Random random;

  public DiceRoller() {
    this(new Random());
  }

  public DiceRoller(Random random) {
    this.random = random;
  }

  /**
   * 
   * @param numDice  number of dice to roll (must be >= 1)
   * @param sides    number of sides per die (must be >= 1)
   * @param modifier flat value added to the total (can be negative)
   * @return a RollResult containing individual rolls and the total
   * @throws IlligalArgumentException if numDice < 1 or sides < 1
   */
  public RollResult roll(int numDice, int sides, int modifier) {
    if (numDice < 1) {
      throw new IllegalArgumentException("numDice must be >= 1, got " + numDice);
    }
    if (sides < 1) {
      throw new IllegalArgumentException("sides must be >= 1, got " + sides);
    }

    List<Integer> rolls = new ArrayList<>();
    for (int i = 0; i < numDice; i++) {
      rolls.add(random.nextInt(sides) + 1);
    }

    int total = rolls.stream().mapToInt(Integer::intValue).sum() + modifier;
    return new RollResult(numDice, sides, modifier, List.copyOf(rolls), total);
  }
}

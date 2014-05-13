/**
 * RandomPivotSelector
 *
 * TODO Description if available.
 */

package ar.com.ariel17.quicksort.pivot.impl;

import java.util.List;
import java.util.Random;

import ar.com.ariel17.quicksort.pivot.Pivot;
import ar.com.ariel17.quicksort.pivot.PivotSelector;

/**
 * TODO
 *
 * @author Ariel Gerardo Ríos (ariel.gerardo.rios@gmail.com)
 */
public class RandomPivotSelector<T extends Comparable<? super T>> implements
PivotSelector<T> {

    private Random random = new Random();

    /**
     * Constructor.
     */
    public RandomPivotSelector() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pivot<T> select(List<T> list) {
        return select(list, 0, list.size()-1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pivot<T> select(List<T> list, Integer minIndex, Integer maxIndex) {
        if (list.size() == 0) {
            return null;
        }

        if (list.size() == 1) {
            return new Pivot<T>(0, list.get(0));
        }

        Integer randomIndex = random.nextInt(maxIndex - minIndex) + minIndex;
        return new Pivot<T>(randomIndex, list.get(randomIndex));
    }
}

// vim:ft=java ts=4 tw=80 cc=+1: 

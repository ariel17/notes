/**
 * ThreeInARowPivotSelector
 *
 * Pivote selector for "three in a row" strategy.
 */

package ar.com.ariel17.quicksort.pivot.impl;

import java.util.List;
import java.util.Random;

import ar.com.ariel17.quicksort.pivot.Pivot;
import ar.com.ariel17.quicksort.pivot.PivotSelector;

/**
 * Selects an element as pivot using the "three in a row" strategy. It consists
 * to take randomly 3 elements from the list and take the lowest as pivot.
 *
 * @author Ariel Gerardo Ríos (ariel.gerardo.rios@gmail.com)
 */
public class ThreeInARowPivotSelector<T extends Comparable<? super T>>
    implements PivotSelector<T> {

    private Random random = new Random();

    /**
     * Constructor.
     */
    public ThreeInARowPivotSelector() {
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

        T minor = null;
        Integer minorIndex = null;

        for (int i = 0; i <= 2; i++) {

            Integer randomIndex = random.nextInt(maxIndex - minIndex) +
                minIndex;

            if (i== 0 || list.get(randomIndex).compareTo(minor) < 0) {
                minor = list.get(randomIndex);
                minorIndex = randomIndex;
            }
        }

        return new Pivot<T>(minorIndex, minor);
    }
}

// vim:ft=java ts=4 tw=80 cc=+1: 

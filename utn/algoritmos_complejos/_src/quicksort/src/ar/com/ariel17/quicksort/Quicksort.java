/**
 * Quicksort
 *
 * TODO Description if available.
 */

package ar.com.ariel17.quicksort;

import java.util.List;

import ar.com.ariel17.quicksort.pivot.PivotSelector;
import ar.com.ariel17.quicksort.pivot.impl.RandomPivotSelector;

/**
 * TODO
 *
 * @author Ariel Gerardo Ríos (ariel.gerardo.rios@gmail.com)
 */
public class Quicksort<T> {

    private PivotSelector selector;

    /**
     * Constructor.
     */
    public Quicksort() {
        selector = new RandomPivotSelector();
    }

    /**
     * Constructor.
     */
    public Quicksort(PivotSelector selector) {
        this.selector = selector;
    }

    /**
     * TODO
     *
     * @param list TODO
     * @return TODO
     */
    public List<T> sort(List<T> list) {
        throw new UnsupportedOperationException("Implement me!");
    }
}

// vim:ft=java ts=4 tw=80 cc=+1: 

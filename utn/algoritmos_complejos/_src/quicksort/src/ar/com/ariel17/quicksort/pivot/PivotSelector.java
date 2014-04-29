/**
 * PivotSelector
 *
 * TODO Description if available.
 */

package ar.com.ariel17.quicksort.pivot;

import java.util.List;

/**
 * TODO
 *
 * @author Ariel Gerardo Ríos (ariel.gerardo.rios@gmail.com)
 */
public interface PivotSelector<T extends Comparable<? super T>> {

    /**
     * TODO
     *
     * @param list TODO
     * @return TODO
     */
    Pivot<T> select(List<T> list);

    /**
     * TODO
     *
     * @param list TODO
     * @param minIndex TODO
     * @param maxIndex TODO
     * @return TODO
     */
    Pivot<T> select(List<T> list, Integer minIndex, Integer maxIndex);
}

// vim:ft=java ts=4 tw=80 cc=+1: 

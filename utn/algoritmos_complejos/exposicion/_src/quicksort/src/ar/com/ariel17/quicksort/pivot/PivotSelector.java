/**
 * PivotSelector
 *
 * Interface that describes the pivot selector behaviour.
 */

package ar.com.ariel17.quicksort.pivot;

import java.util.List;

/**
 * Provides required methods for all pivot selector implementations.
 *
 * @author Ariel Gerardo Ríos (ariel.gerardo.rios@gmail.com)
 */
public interface PivotSelector<T extends Comparable<? super T>> {

    /**
     * Selects an item inside the given list to be considered as pivot,
     * considering all elements.
     *
     * @param list The list containing the elements to be sorted.
     * @return The pivot element containing the item value and position in list.
     */
    Pivot<T> select(List<T> list);

    /**
     * Selects an item inside the given list to be considered as pivot,
     * considering only the elements containing inside limits.
     *
     * @param list The list containing the elements to be sorted.
     * @param minIndex The maximum index value to consider as higher limit in
     * list.
     * @param maxIndex The minimum index value to consider as lower limit in
     * list.
     * @return The pivot element containing the item value and position in
     * restricted list.
     */
    Pivot<T> select(List<T> list, Integer minIndex, Integer maxIndex);
}

// vim:ft=java ts=4 tw=80 cc=+1: 

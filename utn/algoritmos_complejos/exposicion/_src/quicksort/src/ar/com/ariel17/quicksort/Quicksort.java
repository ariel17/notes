/**
 * Quicksort
 *
 * Sort algorithm class implementation and program entry point.
 */

package ar.com.ariel17.quicksort;

import java.util.Arrays;
import java.util.List;

import ar.com.ariel17.quicksort.pivot.Pivot;
import ar.com.ariel17.quicksort.pivot.PivotSelector;
import ar.com.ariel17.quicksort.pivot.impl.RandomPivotSelector;
import ar.com.ariel17.quicksort.pivot.impl.ThreeInARowPivotSelector;

/**
 * Sort algorithm implementing the Quicksort strategy.
 *
 * @author Ariel Gerardo Ríos (ariel.gerardo.rios@gmail.com)
 */
public class Quicksort<T extends Comparable<? super T>> {

    private PivotSelector<T> selector;

    /**
     * Constructor.
     */
    public Quicksort() {
        selector = new RandomPivotSelector<T>();
    }

    /**
     * The entry point for the program example.
     *
     * @param args The program parameters.
     */
    public static void main (String [] args) {
        List<Integer> unsorted = Arrays.asList(5, 23, 4, 9, 77, 8, 7, 7, 48);
        System.out.println(String.format(
            "> Unsorted: %s", Arrays.toString(unsorted.toArray())
        ));

        Quicksort<Integer> qs = new Quicksort<Integer>();
        List<Integer> sorted = qs.sort(unsorted);

        System.out.println(String.format(
            "> Sorted: %s", Arrays.toString(sorted.toArray())
        ));

        PivotSelector<Integer> selector = new ThreeInARowPivotSelector<Integer>();
        qs.setSelector(selector);
        sorted = qs.sort(unsorted);

        System.out.println(String.format(
            ">> Sorted: %s", Arrays.toString(sorted.toArray())
        ));
    }

    /**
     * Sorts all elements on list using the quicksort strategy.
     *
     * @param list The list to be sorted.
     * @return The sorted list.
     */
    public List<T> sort(List<T> list) {

        if (list.size() <= 1) {
            return list;
        }

        sortPartitions(list, selector.select(list), 0, list.size()-1);
        return list;  // the list should be sorted now
    }

    /**
     * Sorts an specific partition of the list using the quicksort strategy.
     *
     * @param list The list to be sorted, containing the partition.
     * @param pivot The pivot element, contained in list and pre-selected.
     * @param minIndex The partition lower limit.
     * @param maxIndex The partition higher limit.
     */
    private void sortPartitions(List<T> list, Pivot<T> pivot, Integer minIndex,
            Integer maxIndex) {
        
        Integer i = minIndex;
        Integer j = maxIndex;

        while(i < pivot.getIndex() || pivot.getIndex() < j) {

            // i > p > j => switch places
            if (list.get(i).compareTo(pivot.getItem()) >= 0 &&
                    pivot.getItem().compareTo(list.get(j)) >= 0) {

                T t = list.get(i);
                list.set(i, list.get(j));
                list.set(j, t);

                // update pivot position if it was changed
                if (i == pivot.getIndex()) {
                    pivot.setIndex(j);
                }
                else if (j == pivot.getIndex()) {
                    pivot.setIndex(i);
                }
            }
            // i < p > j => only increase i-index
            else if (list.get(i).compareTo(pivot.getItem()) <= 0 &&
                    pivot.getItem().compareTo(list.get(j)) > 0) {
                i++;
                continue;
            }
            // i > p < j => only increase j-index
            else if (list.get(i).compareTo(pivot.getItem()) >= 0 &&
                    pivot.getItem().compareTo(list.get(j)) < 0) {
                j--;
                continue;
            }

            // update pivot position if it was changed
            if (i == pivot.getIndex()) {
                j--;
            }
            else if (j == pivot.getIndex()) {
                i++;
            }
            else {
                i++;
                j--;
            }
        }

        // Sorting partitions recursivelly
        //
        // checking size of left partition
        if ((pivot.getIndex() - minIndex) > 1) {
            Integer _maxIndex = pivot.getIndex() - 1;
            Pivot<T> pv = selector.select(list, minIndex, _maxIndex);
            sortPartitions(list, pv, minIndex, _maxIndex);
        }

        // checking size of right partition
        if ((maxIndex - pivot.getIndex()) > 1) {
            Integer _minIndex = pivot.getIndex() + 1;
            Pivot<T> pv = selector.select(list, _minIndex, maxIndex);
            sortPartitions(list, pv, _minIndex, maxIndex);
        }
    }

    /**
     * @param selector The selector implementation to use.
     */
    public void setSelector(PivotSelector<T> selector) {
        this.selector = selector;
    }
}

// vim:ft=java ts=4 tw=80 cc=+1: 

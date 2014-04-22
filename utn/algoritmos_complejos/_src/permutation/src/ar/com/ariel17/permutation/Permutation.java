/**
 * Permutation
 *
 * Generates all permutations of a given string.
 */

package ar.com.ariel17.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates all permutations for an indicated string.
 *
 * @author ariel17 (ariel.gerardo.rios@gmail.com)
 */
public class Permutation {

    /**
     * Default Constructor.
     */
    public Permutation() {
    }

    /**
     * Generates all permutations based on the given string.
     *
     * @param arg Argument to apply permutation.
     * @return A list with all permutations
     */
    public List<String> apply(String arg) {
        return apply("", arg);
    }

    /**
     * Generates all permutations for the post string, applying as the pre
     * string to each result.
     *
     * @param pre The prefix string to attach to result.
     * @param post The post string to apply permutations.
     * @return A list with all permutations with prefixes.
     */
    public List<String> apply(String pre, String post) {
        List<String> list = new ArrayList<String>();

        if (post.length() <= 1) {
            list.add(pre + post);
            return list;
        }

        for (int i = 0; i < post.length(); i++) {
            String temp = post.substring(0, i) + post.substring(i+1);
            list.addAll(this.apply(pre+post.charAt(i), temp));
        }

        return list;
    }


    /**
     * The application's entry point.
     *
     * @param args The call arguments.
     */
    public static void main (String [] args)
    {
        if (args.length == 0) {
            throw new IllegalArgumentException(
                "You must give a string to permute."
            );
        }

        Permutation permutation = new Permutation();
        List<String> result = permutation.apply(args[0]);

        System.out.printf("%d permutations for string '%s'", result.size(),
            args[0]);

        for (String value: result) {
            System.out.println(value);
        }
    }
}

// vim:ft=java ts=4 tw=80 cc=+1: 

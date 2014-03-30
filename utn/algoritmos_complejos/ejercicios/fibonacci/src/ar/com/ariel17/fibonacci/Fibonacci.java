/**
 * Fibonacci
 *
 * Calculates the Fibonacci serie for a number N in Naturals.
 * See: http://en.wikipedia.org/wiki/Fibonacci_number
 */

package ar.com.ariel17.fibonacci;

/**
 * <p>
 *   Calculates the Fibonacci serie for a number N belonging to Naturals. The
 *   serie is a recursive algorithm that returns the addition Fibonnacci result
 *   for the 2 previous values:
 * </p>
 * <pre>
 *   Domain: N in Naturals
 *   f(n) = {
 *      1 &lt;= n &lt;= 2 -&gt; 1
 *      n &gt; 2 -&gt; f(n-1) + f(n-2)
 *   }
 * </pre>
 */
public class Fibonacci {

    /**
     * Default constructor.
     */
    public Fibonacci() {
    }

    /**
     * Calculates the Fibonacci serie for the argument n.
     *
     * @param n The number to calculate Fibonacci serie.
     * @return The Fibonacci number for n.
     * @throws IllegalArgumentException Thrown when n has an invalid domain
     * value; it must belong to Naturals.
     */
    public int f(int n) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException(
                "Parameter n has an invalid value."
            );
        }

        if (1 <= n && n <= 2) {
            return 1;
        }

        return this.f(n-1) + this.f(n-2);
    }

    /**
     * The application main method. It expectes to receive the value of n from
     * the application's parameters.
     *
     * @param args The application's parameters.
     */
    public static void main (String [] args)
    {
        if (args.length == 0) {
            System.out.println(
                "You must indicate a number to calculate the serie."
            );
        }

        int n = Integer.parseInt(args[0]);
        Fibonacci fibonacci = new Fibonacci();

        System.out.printf(
            "The Fibonacci serie for n=%d: %d", n, fibonacci.f(n)
        );
    }
}

// vim:ft=java ts=4 tw=80 cc=+1: 

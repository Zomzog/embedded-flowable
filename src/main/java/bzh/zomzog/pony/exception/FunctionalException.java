package bzh.zomzog.pony.exception;

/**
 * Created by Zomzog on 25/09/2017.
 */

public class FunctionalException extends Exception {

    /**
     * Serial Id
     */
    private static final long serialVersionUID = 7664517780593149849L;

    public FunctionalException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public FunctionalException(final String message) {
        super(message);
    }

}

package dsk.export.exception;

public class ExportException extends Exception {
    private static final long serialVersionUID = 183571498729072062L;

    public ExportException() {
        super();
    }

    public ExportException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExportException(String message) {
        super(message);
    }

    public ExportException(Throwable cause) {
        super(cause);
    }
}

package vlfsoft.common.annotations.processor;

public class ProcessorException extends Exception {

    public ProcessorException() {
    }

    public ProcessorException(String s) {
        super(s);
    }

    public ProcessorException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public ProcessorException(Throwable throwable) {
        super(throwable);
    }

    public ProcessorException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}

package vlfsoft.common.annotations.processor;

import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;

abstract public class BaseProcessor extends AbstractProcessor {

    final protected static String INDENT = "    ";

    public RoundEnvironment roundEnvironment;

    public BaseProcessor printDiagnosticMessage(String format, Object... objects) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, String.format(format, objects));
        return this;
    }

    public BaseProcessor printDiagnosticError(boolean aThrowException, String format, Object... objects) throws ProcessorException {
        String message = String.format(format, objects);
        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, message);
        if (aThrowException) throw new ProcessorException(message);
        return this;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        this.roundEnvironment = roundEnvironment;
        return false;
    }

}
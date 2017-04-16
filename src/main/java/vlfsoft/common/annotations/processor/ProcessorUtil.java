package vlfsoft.common.annotations.processor;

import java.util.List;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;

public class ProcessorUtil {
    private ProcessorUtil() {
    }

    public static List<? extends TypeMirror> getParameterTypes(Element aElement) {
        // http://stackoverflow.com/questions/31255098/find-method-arguments-of-annotated-method-using-java-annotation-processor
        ExecutableType executableType = (ExecutableType) aElement.asType();
        return executableType.getParameterTypes();
    }

    /**
     *
     * @param aElement constructor or method
     * @param i = 0 Type of return if is not void, or Type of first parameter if Type of return is void
     * @return DeclaredType for parameter i in aElement
     */
    public static DeclaredType getParameterDeclaredType(Element aElement, int i) {
        return (DeclaredType) getParameterTypes(aElement).get(i);
    }

    public static List<? extends TypeVariable> getTypeVariables(Element aElement) {
        // http://stackoverflow.com/questions/31255098/find-method-arguments-of-annotated-method-using-java-annotation-processor
        ExecutableType executableType = (ExecutableType) aElement.asType();
        return executableType.getTypeVariables();
    }

    public static Element getPackageElement(Element aElement) {

        if (aElement.getKind() == ElementKind.PACKAGE) {
            return aElement;
        }else {
            return getPackageElement(aElement.getEnclosingElement());
        }
    }

}

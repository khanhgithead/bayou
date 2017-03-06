package edu.rice.bayou.dom_driver;

import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;

public final class Utils {
    private Utils() {
        throw new AssertionError("Do not instantiate this class!");
    }

    public static boolean isRelevantCall(IMethodBinding binding) {
        if (binding == null || binding.getDeclaringClass() == null)
            return false;
        if (Visitor.V().options.API_CLASSES.isEmpty())
            return true;
        String className = binding.getDeclaringClass().getQualifiedName();
        if (className.contains("<")) /* be agnostic to generic versions */
            className = className.substring(0, className.indexOf("<"));
        return Visitor.V().options.API_CLASSES.contains(className);
    }

    public static MethodDeclaration checkAndGetLocalMethod(IMethodBinding binding) {
        if (binding != null)
            for (MethodDeclaration method : Visitor.V().allMethods)
                if (binding.isEqualTo(method.resolveBinding()))
                    return method;
        return null;
    }
}
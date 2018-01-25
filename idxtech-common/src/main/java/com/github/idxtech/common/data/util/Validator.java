package com.github.idxtech.common.data.util;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.expression.ExpressionLanguageGroovyImpl;

import java.util.List;

public final class Validator {

    private final static net.sf.oval.Validator validator;

    static {
        validator = new net.sf.oval.Validator();
        validator.getExpressionLanguageRegistry().registerExpressionLanguage("groovy", new ExpressionLanguageGroovyImpl());
    }

    public static List<ConstraintViolation> validate(final Object validatedObject) {
        return validator.validate(validatedObject);
    }

    public static List<ConstraintViolation> validate(final Object validatedObject, final String... profiles) {
        return validator.validate(validatedObject, profiles);
    }
}

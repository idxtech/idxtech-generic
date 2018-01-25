package com.github.idxtech.common.data.constraint;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;

import java.util.regex.Pattern;

public class IdCardNumberCheck extends AbstractAnnotationCheck<IdCardNumber> {

    private static final Pattern ID_CARD_NUMBER_PATTERN = Pattern.compile("(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)");

    @Override
    public boolean isSatisfied(Object validatedObject, Object valueToValidate,
                               OValContext context, Validator validator) throws OValException {
        if (valueToValidate == null) return true;
        return ID_CARD_NUMBER_PATTERN.matcher(valueToValidate.toString()).matches();
    }
}
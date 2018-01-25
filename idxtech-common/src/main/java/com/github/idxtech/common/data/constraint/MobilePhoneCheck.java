package com.github.idxtech.common.data.constraint;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;

import java.util.regex.Pattern;

public class MobilePhoneCheck extends AbstractAnnotationCheck<MobilePhone> {

    private static final Pattern MOBILE_PHONE_PATTERN = Pattern.compile("^1[^012]\\d{9}$");

    @Override
    public boolean isSatisfied(Object validatedObject, Object valueToValidate,
                               OValContext context, Validator validator) throws OValException {
        if (valueToValidate == null) return true;
        return MOBILE_PHONE_PATTERN.matcher(valueToValidate.toString()).matches();
    }
}
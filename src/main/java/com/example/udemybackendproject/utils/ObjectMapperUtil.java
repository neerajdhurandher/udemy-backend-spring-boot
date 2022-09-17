package com.example.udemybackendproject.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapperUtil {

    public static <S, D> D mapProperties(S source, D destination) {
        BeanUtils.copyProperties(source, destination, getNullPropertyNames(source));
        return destination;
    }

    /**
     * Returns an array of null properties of an object
     *
     * @param source
     * @return
     */
    private static String[] getNullPropertyNames(Object source) {

        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        List<String> emptyNames = new ArrayList<String>();

        for (java.beans.PropertyDescriptor pd : pds) {
// check if value of this property is null then add it to the collection
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null)
                emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}

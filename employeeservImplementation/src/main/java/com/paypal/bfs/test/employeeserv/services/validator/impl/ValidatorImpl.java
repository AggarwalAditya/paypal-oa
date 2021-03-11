package com.paypal.bfs.test.employeeserv.services.validator.impl;

import com.paypal.bfs.test.employeeserv.enums.ValidatorKeys;
import com.paypal.bfs.test.employeeserv.services.validator.Validator;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class ValidatorImpl implements Validator {

    private static final Map<String, Pattern> validatorKeyRegexMap = new HashMap<>();

    static {
        validatorKeyRegexMap.put(ValidatorKeys.DATE_OF_BIRTH.name(), Pattern.compile("(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/](0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)\n"));
        validatorKeyRegexMap.put(ValidatorKeys.EMAIL.name(), Pattern.compile("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"));
        validatorKeyRegexMap.put(ValidatorKeys.ZIPCODE.name(), Pattern.compile("^[1-9][0-9]{5}$"));
    }

    @Override
    public String isValidString(Map<String, String> validatorObject) {
        StringBuilder responseMessage = new StringBuilder();
        if(Objects.nonNull(validatorObject)) {
            for(Map.Entry<String, String> entry : validatorObject.entrySet()) {
                String validatorKey = entry.getKey();
                if(validatorKeyRegexMap.containsKey(validatorKey)) {
                    if(!validatorKeyRegexMap.get(validatorKey).matcher(entry.getValue()).matches()) {
                        responseMessage.append(validatorKey).append(" - not a valid value.").append(System.lineSeparator());
                    }
                } else {
                    responseMessage.append(validatorKey).append(" not found for validation.").append(System.lineSeparator());
                }
            }
        }
        return StringUtils.isEmpty(responseMessage.toString()) ? null : responseMessage.toString();
    }
}

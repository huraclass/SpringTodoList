package com.example.shopping.web.item.form;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
class ItemSaveFormTest {

    @Test
    void 빈검증() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        ItemSaveForm form = new ItemSaveForm();
        form.setItemName("marin");
        form.setPrice(0);
        form.setQuantity(10000);

        Set<ConstraintViolation<ItemSaveForm>> violations = validator.validate(form);
        violations.forEach(vio -> {
            log.info("violation : {}",vio);
            log.info("violation.getMessage : {}", vio.getMessage());
            Assertions.assertThat(vio.getMessage()).isNotEmpty();
        });
    }
}
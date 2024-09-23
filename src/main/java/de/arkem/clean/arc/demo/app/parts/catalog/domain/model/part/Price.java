package de.arkem.clean.arc.demo.app.parts.catalog.domain.model.part;

import de.arkem.clean.arc.demo.app.shared.types.DoubleValueObject;
import io.github.domainprimitives.validation.Constraints;
import io.github.domainprimitives.validation.Validation;

import java.util.function.Consumer;

public class Price extends DoubleValueObject {
    private static Consumer<Validation<Double>> constraints = Constraints.isGreatThanOrEqual(0.1);

    public Price(Double value) {
        super(value, constraints);
    }
}

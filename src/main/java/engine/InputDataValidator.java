package engine;

import java.util.function.Predicate;

class InputDataValidator {

    <T> void validate(T value, Predicate<T> validation, String message) {
        try {
            ValidationType.validate(validation.test(value), message);
        } catch (NullPointerException ex) {
            throw new InvalidInputDataException(message);
        }

    }

    private enum ValidationType {
        TRUE(message -> {}), FALSE(message -> {throw new InvalidInputDataException(message);});
        private boolean validation;
        private ValidationProcess process;

        ValidationType(ValidationProcess process) {
            this.validation = validation;
            this.process = process;
        }

        static void validate(Boolean validation, String message) {
            ValidationType.valueOf(validation.toString().toUpperCase()).process.validate(message);
        }

    }

    interface ValidationProcess {
        void validate(String message);
    }

}

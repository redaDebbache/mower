package engine;

import java.util.function.Predicate;

class InputDataValidator {

    <T> void validate(T value, Predicate<T> validation, String message) {
        try {
           if(!validation.test(value)){
               throw new InvalidInputDataException(message);
           }
        } catch (NullPointerException ex) {
            throw new InvalidInputDataException(message);
        }

    }

}

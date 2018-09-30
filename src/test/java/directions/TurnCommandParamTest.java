package directions;

import model.Orientation;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TurnCommandParamTest {

     static class ExpectedOrientationForGiven {
        private Orientation givenOrientation;
        private Orientation expectedOrientation;

        private int givenIndex;
        private int expectedIndex;

         ExpectedOrientationForGiven(Orientation givenOrientation, Orientation expectedOrientation, int givenIndex, int expectedIndex) {
            this.givenOrientation = givenOrientation;
            this.expectedOrientation = expectedOrientation;
            this.givenIndex = givenIndex;
            this.expectedIndex = expectedIndex;
        }

          Orientation getGivenOrientation() {
             return givenOrientation;
         }

          Orientation getExpectedOrientation() {
             return expectedOrientation;
         }

          int getGivenIndex() {
             return givenIndex;
         }

          int getExpectedIndex() {
             return expectedIndex;
         }
     }
}

package engine;

import model.Mower;

import java.util.stream.Collectors;

class MowerEngine {

    private static final String INCONSISTENT_INPUT_DATA_ERROR_MESSAGE = "Inconsistent input data.";
    private static final String INPUT_FILE_PATTERN = "^(\\d \\d)\\n(\\d \\d [NEWS]\\n[GAD]*\\n{0,1})*";
    private static final String LINE_BREAK = "\n";

    private InputDataValidator validator;
    private MowerBuilder mowerBuilder;

    public MowerEngine(InputDataValidator validator, MowerBuilder mowerBuilder) {
        this.validator = validator;
        this.mowerBuilder = mowerBuilder;
    }

    String start(String inputData) {
        validator.validate(inputData, input -> input != null && !input.isEmpty() && input.matches(INPUT_FILE_PATTERN), INCONSISTENT_INPUT_DATA_ERROR_MESSAGE);
        return mowerBuilder.buildMowers(inputData).map(Mower::move).collect(Collectors.joining(LINE_BREAK));

    }
}

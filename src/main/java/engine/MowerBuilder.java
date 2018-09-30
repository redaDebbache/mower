package engine;

import model.Mower;
import model.Orientation;
import model.Position;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.Integer.valueOf;

class MowerBuilder {
    private static final String SPACE = " ";
    private static final String LINE_BREAK = "\n";
    private static final int BEGIN_INDEX = 0;
    private static final int GROUP = 1;
    private static final int END_POSITION_INDEX = 3;
    private static final int ORIENTATION_INDEX = 4;
    private static final String MOWER_DATA_PATTERN = "(\\d \\d [NEWS]\\n[GAD]*\\n{0,1})";
    private static final int COMMANDS_INDEX = 1;


    Position buildPosition(String formattedFarthestPosition) {
        String[] split = formattedFarthestPosition.split(SPACE);
        return new Position(valueOf(split[0]), valueOf(split[1]));
    }

    Stream<Mower> buildMowers(String data) {
        Position farthestPosition = buildPosition(data.substring(BEGIN_INDEX, END_POSITION_INDEX));
        Scanner scanner = new Scanner(data);
        Pattern pattern = Pattern.compile(MOWER_DATA_PATTERN);

        return scanner.findAll(pattern)
                .map(matcher -> matcher.group(GROUP))
                .filter(Objects::nonNull)
                .map(group -> buildSingleMower(farthestPosition, group));

    }

      Mower buildSingleMower(Position farthestPosition, String datas) {
        String[] split = datas.split(LINE_BREAK);
        String initialPositionAndOrientation = split[BEGIN_INDEX];
        Position initialPosition = buildPosition(initialPositionAndOrientation.substring(BEGIN_INDEX, END_POSITION_INDEX));
        Orientation orientation = Orientation.valueOf(initialPositionAndOrientation.substring(ORIENTATION_INDEX));
        return new Mower(initialPosition, orientation, farthestPosition, split[COMMANDS_INDEX]);
    }
}

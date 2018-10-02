package engine;

import model.Mower;
import model.Orientation;
import model.Position;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerBuilderTest {

    @Test
    public void should_build_consistent_position() {
        //Given
        MowerBuilder builder = new MowerBuilder();
        //When

        Position position = builder.buildPosition("3 5");

        //Then
        assertThat(position).isNotNull();
        assertThat(position.getX()).isEqualTo(3);
        assertThat(position.getY()).isEqualTo(5);

    }

    @Test
    public void should_return_stream_of_mower_input_data() {
        //Given
        MowerBuilder builder = new MowerBuilder();
        //When
        Stream<Mower> mowerInputDataStream = builder.buildMowers("5 5\n" +
                "1 2 N\n" +
                "GAGAGAGAA\n" +
                "3 3 E\n" +
                "AADAADADDA");
        //Then
        List<Mower> collect = mowerInputDataStream.collect(Collectors.toList());
        assertThat(collect.size()).isEqualTo(2);
        assertThat(collect).isEqualTo(Arrays.asList(
                new Mower(new Position(1, 2), Orientation.N, new Position(5, 5)),
                new Mower(new Position(3, 3), Orientation.E, new Position(5, 5))
        ));
    }


    @Test
    public void should_build_consistent_mower() {
        //Given
        MowerBuilder builder = new MowerBuilder();
        //When
        Mower mower = builder.buildSingleMower(new Position(7, 7), "1 2 N\n" +
                "GAGAGAGAA\n");
        //Then
        assertThat(mower).isNotNull();
        assertThat(mower.getPosition()).isEqualTo(new Position(1, 2));
        assertThat(mower.getOrientation()).isEqualTo(Orientation.N);
    }

    @Test
    public void should_return_empty_sream_data_is_empty() {
        //Given
        MowerBuilder builder = new MowerBuilder();
        //When
        Stream<String> commands = builder.devideDataIntoMowerCommands("");
        //Then
        assertThat(commands).isEmpty();
    }

    @Test
    public void should_return_stream_of_mower_commands_and_positions() {
        //Given
        MowerBuilder builder = new MowerBuilder();
        //When
        List<String> commands = builder.devideDataIntoMowerCommands("1 2 N\n" +
                "GAGAGAGAA\n" +
                "3 3 E\n" +
                "AADAADADDA").collect(Collectors.toList());
        //Then
        assertThat(commands.size()).isEqualTo(2);
        assertThat(commands.get(0)).isEqualTo("1 2 N\n" +
                "GAGAGAGAA\n");
        assertThat(commands.get(1)).isEqualTo("3 3 E\n" +
                "AADAADADDA");
    }
}
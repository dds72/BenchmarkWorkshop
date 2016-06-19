import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import ru.tct.Benchmark.BenchmarkContainer;

import java.io.IOException;

/**
 * Created by dds on 19.06.2016.
 */
public class BenchmarksRunner {
    public static void main(String[] args) {
        try {
            for (String arg :
                    args) {
                switch (Commands.valueOf(arg)) {
                    case BENCHMARK:
                        Options opt = new OptionsBuilder()
                                .include(BenchmarkContainer.class.getSimpleName())
                                .warmupIterations(5)
                                .measurementIterations(5)
                                .forks(1)
                                .build();

                        new Runner(opt).run();
                        break;

                    case PAUSE:

                        System.in.read();
                        break;

                    default:
                        break;
                }
            }
        } catch (RunnerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private enum Commands {
        BENCHMARK,
        PAUSE
    }
}

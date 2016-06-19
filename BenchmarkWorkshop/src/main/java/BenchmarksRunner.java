import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

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
                    case benchmark:
                        Options opt = new OptionsBuilder()
                                .include(BenchmarkContainer.class.getSimpleName())
                                .warmupIterations(5)
                                .measurementIterations(5)
                                .forks(1)
                                .build();

                        new Runner(opt).run();
                        break;

                    case pause:

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
        benchmark,
        pause
    }
}

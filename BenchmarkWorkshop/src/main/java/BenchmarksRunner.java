/**
 * Created by dds on 19.06.2016.
 */
public class BenchmarksRunner {
    public static void main(String[] args) {
        for (String arg :
                args) {
            switch (Commands.valueOf(arg)) {
                case benchmark:

                    break;
                case pause:

                    break;

                default:
                    break;
            }
        }
    }

    private enum Commands {
        benchmark,
        pause
    }
}

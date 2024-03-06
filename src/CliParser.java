import org.apache.commons.cli.*;

public class CliParser {
    public Options options = new Options();
    public CommandLineParser parser = new GnuParser();
    public HelpFormatter formatter = new HelpFormatter();

    public CliParser() {
        options.addOption(new Option("h", "help", false, "Display this help text"));
        options.addOption(new Option("v", "verbose", false, "Print verbose information"));
        options.addOption(new Option("n", "thread", true, "Set the number of threads"));
        options.addOption(new Option("t", "time", true, "Set thread execution time (in seconds)"));
        options.addOption(new Option("s", "step", true, "Set the sequence step value for all sums"));
    }
}

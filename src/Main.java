import org.apache.commons.cli.CommandLine;

public class Main {
    public static void main(String[] args) {
        CliParser cli = new CliParser();
        CommandLine cmd;

        try {
            cmd = cli.parser.parse(cli.options, args);

            if (cmd.hasOption("h")) {
                cli.formatter.printHelp("Lab1", cli.options);
                System.exit(0);
            }

            int numberOfThreads = cmd.hasOption("n") ? Integer.parseInt(cmd.getOptionValue("n")) : 1;
            int executionTime = cmd.hasOption("t") ? Integer.parseInt(cmd.getOptionValue("t")) : 1;
            int stepValue = cmd.hasOption("s") ? Integer.parseInt(cmd.getOptionValue("s")) : 1;

            if (cmd.hasOption("v")) {
                System.out.println("Threads: " + numberOfThreads);
                System.out.println("Step: " + stepValue);
                System.out.println("Time: " + executionTime + " sec.\n");
            }

            BreakThread breakThread = new BreakThread(executionTime);

            for (int i = 1; i <= numberOfThreads; i++)
                new SumThread(i, stepValue, breakThread).start();

            new Thread(breakThread).start();

        } catch (org.apache.commons.cli.ParseException e) {
            System.out.println(e.getMessage());
            cli.formatter.printHelp("Lab1", cli.options);
            System.exit(1);
        }
    }
}
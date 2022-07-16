// This program will read a text file, manipulate some of the data read, and write the results to a text file. The file
// named PovertyData.txt, found in the downloads folder contains the raw data that will be input into the program.
// The raw data from the file is read and the total population, child population, child poverty population by each state
// code will be summarized. The summarized data will be formatted and printed in a new text file named
// UpdatedPovertyData.txt.

import java.io.*;
import java.util.ArrayList;

public class Assignment5 {

    static ArrayList<StateTotals> stateSummary = new ArrayList<StateTotals>();

    // Getter method to read the state code for a state at given index.
    public static int getStateCode(int index) {
        return stateSummary.get(index).getStateCode();
    }

    // Getter method to read the total population for a state at given index.
    public static int getTotalPopulation(int index) {
        return stateSummary.get(index).getTotalPopulation();
    }

    // Getter method to read the total child population for a state at given index.
    public static int getTotalChildPopulation(int index) {
        return stateSummary.get(index).getTotalChildPopulation();
    }

    // Getter method to read the total child poverty population for a state at given index.
    public static int getTotalChildPovertyPopulation(int index) {
        return stateSummary.get(index).getTotalChildPovertyPopulation();
    }

    public static void main(String[] args) throws IOException {

        try {
            // Read and separate the raw data by attribute from the file PovertyData.txt.
            BufferedReader input = new BufferedReader(new FileReader("PovertyData.txt"));
            String line = null;
            while ((line = input.readLine()) != null) {
                int stateCode = Integer.parseInt(line.substring(0, 2).trim());
                int totalPopulation = Integer.parseInt(line.substring(83, 90).trim());
                int childPopulation = Integer.parseInt(line.substring(92, 99).trim());
                int childPovertyPopulation = Integer.parseInt(line.substring(101, 108).trim());

                // Instantiate a StateTotals object for each record in the file.
                StateTotals curStateTotals = new StateTotals(stateCode, totalPopulation, childPopulation,
                    childPovertyPopulation);

                // If a StateTotals object doesn't exist in the stateSummary ArrayList, add it to the end of the ArrayList.
                // Otherwise, add the current total population, child population, and child poverty totals to the StateTotals
                // so far.
                // population from the index defined will be totaled in the addToStateTotals method.
                int index = -1;
                if ((index = stateSummary.indexOf(curStateTotals)) >= 0) {
                    stateSummary.get(index).addToStateTotals(totalPopulation, childPopulation, childPovertyPopulation);
                } else {
                    stateSummary.add(curStateTotals);
                }
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // The UpdatedPoverty.txt file is formatted where the first field is the state code, the second field is the
        // total population, the third field is the total child population, and the fourth field is the total child
        // poverty population.
        PrintWriter output = new PrintWriter("UpdatedPovertyData.txt");
        output.printf("%-14s%-20s%-20s%-20s\n", "State Code", "Total Population", "Child Population",
            "Child Poverty Population");

        // Print the state code, total population, total child population, and total child poverty population for all
        // records in the input file.
        for (int i = 0; i < stateSummary.size(); i++) {
            output.printf("%-14d%-20d%-20d%-20d\n", getStateCode(i), getTotalPopulation(i), getTotalChildPopulation(i),
                getTotalChildPovertyPopulation(i));
        }
        output.flush();
        output.close();
    }
}
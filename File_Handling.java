import java.io.*;

     
public class File_Handling {
    public static void main(String[] args) {
        // File paths
        String inputFilePath = "c:/Users/Dell/Documents/input.txt";    // Input file path
        String outputFilePath = "c:/Users/Dell/Documents/output.txt";  // Output file path

        // Initialize counters
        int wordCount = 0;
        int lineCount = 0;

        // Open the input file and output file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            // Process each line of the input file
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;  // Increment line count for each line
                wordCount += countWordsInLine(line);  // Count words in the current line
            }

            // Write the processed data to the output file
            writer.write("Line Count: " + lineCount + "\n");
            writer.write("Word Count: " + wordCount + "\n");

            System.out.println("Processing complete. Results written to " + outputFilePath);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found.");
        } catch (IOException e) {
            System.out.println("Error reading or writing files: " + e.getMessage());
        }
    }

    // Method to count words in a line
    private static int countWordsInLine(String line) {
        // Split the line into words and return the word count
        if (line.trim().isEmpty()) {
            return 0; // If the line is empty, return 0
        }
        String[] words = line.split("\\s+"); // Split by spaces and tabs
        return words.length;
    }
}

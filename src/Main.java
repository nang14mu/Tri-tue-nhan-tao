public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "input.txt";

            GraphFileReader reader = new GraphFileReader();
            InputData inputData = reader.readFromFile(filePath);

            BestFirstSearch bestFirstSearch = new BestFirstSearch();
            SearchResult result = bestFirstSearch.search(
                    inputData.getGraph(),
                    inputData.getStart(),
                    inputData.getGoal());

            TablePrinter printer = new TablePrinter();
            printer.printToFile(result.getSteps(), result.getPath(), "output.txt");

        } catch (Exception e) {
            System.out.println("Fault: " + e.getMessage());
        }
    }
}
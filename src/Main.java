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
            printer.printSteps(result.getSteps());
            printer.printPath(result.getPath());

        } catch (Exception e) {
            System.out.println("Fault: " + e.getMessage());
        }
    }
}
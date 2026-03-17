import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GraphFileReader {

    public InputData readFromFile(String filePath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String firstLine = br.readLine();
            if(firstLine == null || firstLine.trim().isEmpty()) {
                throw new IllegalArgumentException("Empty file");
            }

            int n = Integer.parseInt(firstLine.trim());
            Graph graph = new Graph();

            List<String> rawLines = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                String line = br.readLine();
                if(line == null) {
                    throw new IllegalArgumentException("Missing the vertex's data from line " + (i+2));
                }
                rawLines.add(line.trim());

                String[] parts = line.split("->",2);
                if(parts.length != 2) {
                    throw new IllegalArgumentException("Wrong format from line " + line);
                }

                String left = parts[0].trim();
                String[] leftTokens = left.split("\\s+");
                if(leftTokens.length < 2) {
                    throw new IllegalArgumentException("Wrong format from line " + line);
                }

                String nodeName = leftTokens[0];
                int heuristic = Integer.parseInt(leftTokens[1]);

                graph.addNode(nodeName, heuristic);
            }

            for(String line : rawLines) {
                String[] parts = line.split("->", 2);
                String left = parts[0].trim();
                String right = parts[1].trim();

                String[] leftTokens = left.split("\\s+");
                String from = leftTokens[0];

                if(!right.isEmpty()) {
                    String[] neighbors = right.split("\\s+");
                    for(String to : neighbors) {
                        graph.addEdge(from, to);
                    }
                }
            }

            String lastLine = br.readLine();
            if(lastLine == null || lastLine.trim().isEmpty()) {
                throw new IllegalArgumentException("Missing start and goal line");
            }

            String[] sg = lastLine.trim().split("\\s+");
            if(sg.length != 2) {
                throw new IllegalArgumentException("Last line must be in (Start, Goal) format");
            }

            String start = sg[0];
            String goal = sg[1];

            if(!graph.containsNode(start) || !graph.containsNode(goal)) {
                throw new IllegalArgumentException("Start or Goal isn't available in the graph");
            }

            return new InputData(graph, start, goal);
        }
    }
}

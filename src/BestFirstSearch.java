import java.util.*;

public class BestFirstSearch {

    public SearchResult search(Graph graph, String start, String goal) {
        PriorityQueue<Node> open = new PriorityQueue<>(Comparator.comparingInt(Node::getHeuristic));
        Set<String> closed = new HashSet<>();
        Map<String, String> parent = new HashMap<>();
        List<StepRecord> steps = new ArrayList<>();

        Node startNode = graph.getNode(start);
        open.offer(startNode);
        parent.put(start, null);

        while (!open.isEmpty()) {
            Node current = open.poll();

            if(closed.contains(current.getName())) {
                continue;
            }

            closed.add(current.getName());

            List<String> generated = new ArrayList<>();

            for (Node neighbor : graph.getNeighbors(current.getName())) {
                String neighborName = neighbor.getName();

                if(!closed.contains(neighborName) && !parent.containsKey(neighborName)) {
                    parent.put(neighborName, current.getName());
                    open.offer(neighbor);
                    generated.add(neighbor.toString());
                }
            }

            String expandedState = current.toString();
            String nextState = generated.isEmpty() ? " - " : String.join(", ", generated);
            String listL = formatOpenList(open, closed);

            steps.add(new StepRecord(expandedState, nextState, listL));

            if(current.getName().equals(goal)) {
                return new SearchResult(reconstructPath(parent, goal), steps);
            }
        }

        return new SearchResult(Collections.emptyList(), steps);
    }

    private List<String> reconstructPath(Map<String, String> parent, String goal) {
        List<String> path = new ArrayList<>();
        String current = goal;

        while (current != null) {
            path.add(current);
            current = parent.get(current);
        }

        Collections.reverse(path);
        return path;
    }

    private String formatOpenList(PriorityQueue<Node> open, Set<String> closed) {
        List<Node> temp = new ArrayList<>(open);
        temp.removeIf(node -> closed.contains(node.getName()));
        temp.sort(Comparator.comparingInt(Node::getHeuristic));

        if(temp.isEmpty()) {
            return "-";
        }

        List<String> result = new ArrayList<>();
        for(Node node : temp) {
            result.add(node.toString());
        }

        return String.join(", ", result);
    }
}

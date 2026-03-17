public class InputData {
    private final Graph graph;
    private final String start;
    private final String goal;

    public InputData(Graph graph, String start, String goal) {
        this.graph = graph;
        this.start = start;
        this.goal = goal;
    }

    public Graph getGraph() {
        return graph;
    }

    public String getStart() {
        return start;
    }

    public String getGoal() {
        return goal;
    }
}

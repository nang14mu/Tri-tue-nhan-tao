public class Node {
    private String name;
    private int heuristic;

    public Node(String name, int heuristic) {
        this.heuristic = heuristic;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    @Override
    public String toString() {
        return name + "-" + heuristic;
    }
}

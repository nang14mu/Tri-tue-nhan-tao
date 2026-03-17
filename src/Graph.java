import java.util.*;

public class Graph {
    private Map<String, Node> nodes;
    private Map<String, List<Node>> adjecencyList;

    public Graph() {
        nodes = new HashMap<>();
        adjecencyList = new HashMap<>();
    }

    public void addNode(String name, int heuristic) {
        Node node = new Node(name,heuristic);
        nodes.put(name,node);
        adjecencyList.putIfAbsent(name,new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        if(!nodes.containsKey(from) || !nodes.containsKey(to)) {
            throw new IllegalArgumentException("The vertex isn't available");
        }
        adjecencyList.get(from).add(nodes.get(to));
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

    public List<Node> getNeighbors(String name) {
        return adjecencyList.getOrDefault(name, Collections.emptyList());
    }

    public boolean containsNode(String name) {
        return nodes.containsKey(name);
    }
}

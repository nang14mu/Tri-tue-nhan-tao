import java.util.List;

public class SearchResult {
    private final List<String> path;
    private final List<StepRecord> steps;

    public SearchResult(List<String> path, List<StepRecord> steps) {
        this.path = path;
        this.steps = steps;
    }

    public List<String> getPath() {
        return path;
    }

    public List<StepRecord> getSteps() {
        return steps;
    }
}

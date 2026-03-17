public class StepRecord {
    private final String expandedState;
    private final String nextStates;
    private final String listL;

    public StepRecord(String expandedState, String nextState, String listL) {
        this.expandedState = expandedState;
        this.nextStates = nextState;
        this.listL = listL;
    }

    public String getExpandedState() {
        return expandedState;
    }

    public String getNextStates() {
        return nextStates;
    }

    public String getListL() {
        return listL;
    }
}

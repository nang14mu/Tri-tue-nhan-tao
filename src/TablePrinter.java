import java.util.List;

public class TablePrinter {

    public void printSteps(List<StepRecord> steps) {
        String line = "+-----+----------------------+---------------------------+--------------------------------------+";
        System.out.println(line);
        System.out.printf("| %-3s | %-20s | %-25s | %-36s |%n",
                "Bước", "Phát triển trạng thái", "Trạng thái kế", "Danh sách L");
        System.out.println(line);

        for (int i = 0; i < steps.size(); i++) {
            StepRecord step = steps.get(i);
            System.out.printf("| %-3d | %-20s | %-25s | %-36s |%n",
                    i + 1,
                    step.getExpandedState(),
                    step.getNextStates(),
                    step.getListL());
        }

        System.out.println(line);
    }

    public void printPath(List<String> path) {
        if (path == null || path.isEmpty()) {
            System.out.println("Không tìm thấy đường đi.");
        } else {
            System.out.println("Đường đi tìm được: " + String.join(" -> ", path));
        }
    }
}
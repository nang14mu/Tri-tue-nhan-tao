import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TablePrinter {

    public void printToFile(List<StepRecord> steps, List<String> path, String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {

            String line = "+-----+----------------------+---------------------------+--------------------------------------+";
            writer.println(line);
            writer.printf("| %-3s | %-20s | %-25s | %-36s |%n",
                    "Bước", "Phát triển trạng thái", "Trạng thái kế", "Danh sách L");
            writer.println(line);

            for (int i = 0; i < steps.size(); i++) {
                StepRecord step = steps.get(i);
                writer.printf("| %-3d | %-20s | %-25s | %-36s |%n",
                        i,
                        step.getExpandedState(),
                        step.getNextStates(),
                        step.getListL());
            }

            writer.println(line);

            if (path == null || path.isEmpty()) {
                writer.println("Không tìm thấy đường đi.");
            } else {
                writer.println("Đường đi tìm được: " + String.join(" -> ", path));
            }

        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }
}
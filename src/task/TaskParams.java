package task;

import java.util.ArrayList;

public class TaskParams {
    private String taskCode;
    private ArrayList<String> taskParams;

    public TaskParams(String taskCode, ArrayList<String> taskParams) {
        this.taskCode = taskCode;
        this.taskParams = taskParams;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public ArrayList<String> getTaskParams() {
        return taskParams;
    }

    public void setTaskParams(ArrayList<String> taskParams) {
        this.taskParams = taskParams;
    }
}

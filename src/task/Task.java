package task;

import java.util.Map;

public class Task {
    private String themeCode;
    private String taskCode;
    private String taskDescription;
    private Map<String,String> taskParams;

    public Task(String themeCode, String taskCode, String taskDescription) {
        this.themeCode = themeCode;
        this.taskCode = taskCode;
        this.taskDescription = taskDescription;
    }

    public Task(String themeCode, String taskCode, String taskDescription, Map<String, String> taskParams) {
        this.themeCode = themeCode;
        this.taskCode = taskCode;
        this.taskDescription = taskDescription;
        this.taskParams = taskParams;
    }
    public Task(String taskCode, Map<String, String> taskParams) {
        this.taskCode = taskCode;
        this.taskParams = taskParams;
    }
    public Task() {
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getThemeCode() {
        return themeCode;
    }

    public void setThemeCode(String themeCode) {
        this.themeCode = themeCode;
    }

    public Map<String, String> getTaskParams() {
        return taskParams;
    }

    public void setTaskParams(Map<String, String> taskParams) {
        this.taskParams = taskParams;
    }

    @Override
    public String toString() {
        return this.taskDescription;
    }
}

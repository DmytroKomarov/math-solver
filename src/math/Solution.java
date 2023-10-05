package math;

import resource.resource;
import task.Task;
import task.TaskParams;
import task.Theme;

import java.util.ArrayList;

import static resource.resource.*;


public class Solution {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[37m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        rainbowPrint("Hello! :)");
        rainbowPrint("The MathSolver will help you solve some mathematical problems.");
        resource.getResources();

        application.Appl.run();

        System.out.println();
        rainbowPrint("Program completed. Buy... :)");
    }



    public static ArrayList<Theme> getTheme() {
        ArrayList<Theme> themes = theme;
        return theme;
    }

    public static ArrayList<Task> getTaskByTheme(String themeCode) throws Exception {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : task) {
            if (task.getThemeCode().equals(themeCode)) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    public static ArrayList<String> getParamsByTask(String taskCode) {
        ArrayList<String> taskPrms = new ArrayList<>();
        for (TaskParams taskParams : taskParams) {
            if (taskParams.getTaskCode().equals(taskCode)) {
                taskPrms = taskParams.getTaskParams();
                break;
            }
        }
        return taskPrms;
    }

    private static void rainbowPrint(String text) {
        int i = 0;
        char[] letters = text.toCharArray();
        String color = new String();
        for (char letter : letters) {
            i++;
            switch (i % 8) {
                case 0:
                    color = RED;
                    break;
                case 1:
                    color = GREEN;
                    break;
                case 2:
                    color = YELLOW;
                    break;
                case 3:
                    color = BLUE;
                    break;
                case 4:
                    color = PURPLE;
                    break;
                case 5:
                    color = CYAN;
                    break;
                case 6:
                    color = WHITE;
                    break;
                case 7:
                    color = RESET;

            }
            System.out.print(color + letter);
        }
        System.out.println(RESET);
    }

}

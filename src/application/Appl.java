package application;

import math.Solver;
import task.Task;
import task.Theme;

import java.util.*;

import static math.Solution.*;

public class Appl {
    private static Map<Integer, Theme> themes = new HashMap<>();
    private static Map<Integer, Task> tasks = new HashMap<>();
    private static Map<String, String> taskParams = new HashMap<>();
    private static String selected;
    private static String entered;
    private static String themeCode;
    private static String taskCode;
    private static ArrayList<String> params;
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

    public static void run() {


        while (true) {
            //begin
            System.out.println();
            System.out.println("Themes:");
            //get theme

            themes = themeToMap(getTheme());
            printTheme(themes);
            selected = getSelect();
            if (selected.equalsIgnoreCase("exit")) {
                break;
            }
            if (themes.get(Integer.parseInt(selected)) == null) {
                System.out.println(RED + "Out of range." + RESET);
                continue;
            }
            themeCode = themes.get(Integer.parseInt(selected)).getThemeCode();

            while (true) {
                try {
                    tasks = taskToMap(getTaskByTheme(themeCode));
                } catch (Exception e) {
                    System.out.println("Error: MS-0003. Theme is not exists");
                }
                System.out.println();
                System.out.println("Tasks:");
                printTask(tasks);
                selected = getSelect();

                if (selected.equalsIgnoreCase("exit")) {
                    break;
                }
                if (tasks.get(Integer.parseInt(selected)) == null) {
                    System.out.println(RED + "Out of range." + RESET);
                    continue;
                }
                taskCode = tasks.get(Integer.parseInt(selected)).getTaskCode();
                params = getParamsByTask(taskCode);
                while (true) {
                    System.out.println(GREEN + "Enter parameters:" + RESET);

                    taskParams.clear();
                    //Scanner scan = new Scanner(System.in);
                    for (String param : params) {
                        System.out.print(param + ": ");
                        entered = getEnter();
                        if (entered.equalsIgnoreCase("exit")) {
                            break;
                        }
                        taskParams.put(param,entered);
                    }
                    if (entered.equalsIgnoreCase("exit")) {
                        break;
                    }
                    Task task = new Task(taskCode, taskParams);
                    System.out.println(Solver.getSolve(task));
                    System.out.println();
                }

            }
        }
    }

    private static Map<Integer, Theme> themeToMap(ArrayList<Theme> themes) {
        Map<Integer, Theme> themeMap = new HashMap<>();
        int i = 0;
        for (Theme theme : themes) {
            i++;
            themeMap.put((Integer) i, theme);
        }
        return themeMap;
    }

    private static void printTheme(Map<Integer, Theme> themeMap) {
        Iterator<Map.Entry<Integer, Theme>> itr = themeMap.entrySet().iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    private static Map<Integer, Task> taskToMap(ArrayList<Task> tasks) {
        Map<Integer, Task> taskMap = new HashMap<>();
        int i = 0;
        for (Task task : tasks) {
            i++;
            taskMap.put((Integer) i, task);
        }
        return taskMap;
    }

    private static void printTask(Map<Integer, Task> taskMap) {
        Iterator<Map.Entry<Integer, Task>> itr = taskMap.entrySet().iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    private static String getSelect() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print(GREEN + "Select number or exit: " + RESET);
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                return "exit";
            }
            //check number
            try {
                int selectThemeNumber = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(RED + "Wrong number." + RESET);
                continue;
            }
            return input;
        }

    }

    private static String getEnter() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                return "exit";
            }
            //check number
//            try {
//                int selectThemeNumber = Integer.parseInt(input);
//            } catch (NumberFormatException e) {
//                System.out.println(RED + "Wrong number." + RESET);
//                continue;
//            }
            return input;
        }

    }
}

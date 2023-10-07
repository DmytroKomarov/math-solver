package resource;

import task.Task;
import task.TaskParams;
import task.Theme;

import java.util.ArrayList;
import java.util.Arrays;

public class resource {
    public static ArrayList<Theme> theme;
    public static ArrayList<Task> task;
    public static ArrayList<TaskParams> taskParams;
    public static void getResources(){
        theme = new ArrayList<>();
        theme.add(new Theme("Divisors","Дільники та кратні"));
        theme.add(new Theme("Power","Степень числа"));

        task = new ArrayList<>();
        task.add(new Task("Divisors","GetNumberDividers","Дільники числа"));
        task.add(new Task("Divisors","GetMultipleOfNumber","Кратні числа"));
        task.add(new Task("Divisors","GetSimpleComplexNumberType","Просте/Складене число"));

        task.add(new Task("Divisors","GetSimpleByRange","Прості числа діапазону (включно)"));
        task.add(new Task("Divisors","GetComplexByRange","Складені числа діапазону (включно)"));
        task.add(new Task("Divisors","GetPrimeFactors","Прості множники числа"));
        task.add(new Task("Divisors","GetGreatestCommonFactor","НСД/НСК (n1,n2,n...)"));
        task.add(new Task("Divisors","GetHiddenDigits","Скриті цифри (12*3/1*3*)"));

        task.add(new Task("Power","GetPower","Стапінь числа"));

        taskParams = new ArrayList<>();
        taskParams.add(new TaskParams("GetNumberDividers",new ArrayList<String>(Arrays.asList ("number"))));
        taskParams.add(new TaskParams("GetMultipleOfNumber",new ArrayList<String>(Arrays.asList ("number","count"))));
        taskParams.add(new TaskParams("GetSimpleComplexNumberType",new ArrayList<String>(Arrays.asList ("number"))));
        taskParams.add(new TaskParams("GetSimpleByRange",new ArrayList<String>(Arrays.asList ("numberFrom","numberTo"))));
        taskParams.add(new TaskParams("GetComplexByRange",new ArrayList<String>(Arrays.asList ("numberFrom","numberTo"))));
        taskParams.add(new TaskParams("GetPrimeFactors",new ArrayList<String>(Arrays.asList ("number"))));
        taskParams.add(new TaskParams("GetGreatestCommonFactor",new ArrayList<String>(Arrays.asList ("numbers"))));
        taskParams.add(new TaskParams("GetHiddenDigits",new ArrayList<String>(Arrays.asList ("number","divisor"))));

        taskParams.add(new TaskParams("GetPower",new ArrayList<String>(Arrays.asList ("number","power"))));

    }
}

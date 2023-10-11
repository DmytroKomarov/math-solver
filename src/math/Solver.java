package math;

import task.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.abs;

public class Solver {
    private static String nm = new String();
    private static String dg = new String();
    public static boolean isHidden;

    public static String getSolve(Task task) {
        String solve = new String();
        String taskCode = task.getTaskCode();
        Map<String, String> taskParams = task.getTaskParams();
        if (taskCode.equals("GetNumberDividers")) {
            solve = getNumberDividers(taskParams);
        } else if (taskCode.equals("GetMultipleOfNumber")) {
            solve = getMultipleOfNumber(taskParams);
        } else if (taskCode.equals("GetPower")) {
            solve = getPower(taskParams);
        } else if (taskCode.equals("GetSimpleComplexNumberType")) {
            solve = getSimpleComplexNumberType(taskParams);
        } else if (taskCode.equals("GetSimpleByRange")) {
            solve = getSimpleByRange(taskParams);
        } else if (taskCode.equals("GetComplexByRange")) {
            solve = getComplexByRange(taskParams);
        } else if (taskCode.equals("GetPrimeFactors")) {
            solve = getPrimeFactors(taskParams);
        } else if (taskCode.equals("GetGreatestCommonFactor")) {
            solve = getGreatestCommonFactor(taskParams);
        } else if (taskCode.equals("GetHiddenDigits")) {
            solve = getHiddenDigits(taskParams);
        } else {
            solve = "Error: MS-0001. Unknown task";
        }
        return solve;
    }

    private static String getNumberDividers(Map<String, String> taskParams) {
        String solve = new String();
        int number = Integer.parseInt(taskParams.get("number"));
        for (int i = 1; i < number + 1; i++) {
            if (number % i == 0) {
                solve = solve + i + ", ";
            }
        }
        if (solve.length() > 0) {
            solve = solve.substring(0, solve.length() - 2);
        }
        return solve;
    }

    private static String getMultipleOfNumber(Map<String, String> taskParams) {
        String solve = new String();
        int number = Integer.parseInt(taskParams.get("number"));
        int count = Integer.parseInt(taskParams.get("count"));
        for (int i = 1; i < count + 1; i++) {
            solve = solve + number * i + ", ";
        }
        if (solve.length() > 0) {
            solve = solve.substring(0, solve.length() - 2);
        }
        return solve;
    }

    private static String getPower(Map<String, String> taskParams) {
        String solve = new String();
        int number = Integer.parseInt(taskParams.get("number"));
        int power = Integer.parseInt(taskParams.get("power"));
        double slv = number;
        for (int i = 0; i < power - 1; i++) {
            slv = slv * number;
        }
        solve = String.valueOf(slv);
        return solve;
    }

    private static String getSimpleComplexNumberType(Map<String, String> taskParams) {
        String solve = new String();
        int number = Integer.parseInt(taskParams.get("number"));
        int count = 0;
        for (int i = 1; i < number + 1; i++) {
            if (number % i == 0) {
                solve = solve + i + ", ";
                count++;
            }
        }
        if (solve.length() > 0) {
            solve = solve.substring(0, solve.length() - 2);
        }
        if (count == 2) {
            solve = "Просте (має два різні дільники: " + solve + ")";
        } else if (count > 2) {
            solve = "Складене (має більше двох різних дільників: " + solve + ")";
        } else {
            solve = "Тип числа не визначено (" + solve + ")";
        }
        return solve;
    }

    private static String getSimpleByRange(Map<String, String> taskParams) {
        String solve = new String();
        int numberFrom = Integer.parseInt(taskParams.get("numberFrom"));
        int numberTo = Integer.parseInt(taskParams.get("numberTo"));
        for (int number = numberFrom; number < numberTo; number++) {
            int count = 0;
            for (int i = 1; i < number + 1; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                solve = solve + number + ", ";
            }
        }
        if (solve.length() > 0) {
            solve = solve.substring(0, solve.length() - 2);
        }
        solve = "Прості числа x, що належать діапазону " + numberFrom + "<=x<=" + numberTo + ": " + solve;
        return solve;
    }

    private static String getComplexByRange(Map<String, String> taskParams) {
        String solve = new String();
        int numberFrom = Integer.parseInt(taskParams.get("numberFrom"));
        int numberTo = Integer.parseInt(taskParams.get("numberTo"));
        for (int number = numberFrom; number < numberTo; number++) {
            int count = 0;
            for (int i = 1; i < number + 1; i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count > 2) {
                solve = solve + number + ", ";
            }
        }
        if (solve.length() > 0) {
            solve = solve.substring(0, solve.length() - 2);
        }
        solve = "Складені числа x, що належать діапазону " + numberFrom + "<=x<=" + numberTo + ": " + solve;
        return solve;
    }

    private static String getPrimeFactors(Map<String, String> taskParams) {
        String solve = new String();
        int number = Integer.parseInt(taskParams.get("number"));
        int num = number;
        // Починаємо розклад з найменшого простого числа - 2
        int divisor = 2;

        while (num > 1) {
            if (num % divisor == 0) {
                // Якщо число ділиться на divisor без остатка, то divisor - простий множник
                solve = solve + divisor + "*";
                num = num / divisor;
            } else {
                // Якщо не ділиться, збільшуємо divisor
                divisor++;
            }
        }

        if (solve.length() > 0) {
            solve = solve.substring(0, solve.length() - 1);
        }
        solve = "Прості множники числа " + number + ": " + solve;
        return solve;

    }

    private static String getGreatestCommonFactor(Map<String, String> taskParams) {
        String solve = new String();
        String numbersString = taskParams.get("numbers").replaceAll(" ", ",");

        int[] numbers = parseIntArray(numbersString);

        if (numbers.length == 0) {
            throw new IllegalArgumentException("Error: MS-0002. Array is empty");
        }
        int gcd = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            gcd = findGCD(gcd, numbers[i]);
        }

        int lcm = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            lcm = findLCM(lcm, numbers[i]);
        }

        solve = "НСД(" + numbersString + ")=" + gcd + (char) 10 + (char) 13 + "НСК(" + numbersString + ")=" + lcm;
        return solve;
    }

    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int[] parseIntArray(String input) {
        String[] tokens = input.split(",");
        int[] intArray = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            intArray[i] = Integer.parseInt(tokens[i]);
        }

        return intArray;
    }

    private static int findLCM(int num1, int num2) {
        return (num1 * num2) / findGCD(num1, num2);
    }

    private static String getHiddenDigits(Map<String, String> taskParams) {
        String solve = new String();
        String number = taskParams.get("number");//123* 1*3*
        String divisor = taskParams.get("divisor");

        String regex = "\\*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        if (count == 0) {
            return "Error: MS-0004. Missing *-symbol";
        }
        String numbersA = new String();
        String digitsA = new String();
        String numbersB = new String();
        String digitsB = new String();
        int numberA = 0;
        int numberB = 0;
        for (int i = 0; i <= 9; i++) {
            numberA = Integer.parseInt(number.replaceAll(regex, String.valueOf(i)));
            if (numberA % Integer.parseInt(divisor) == 0) {
                digitsA = digitsA + i + ", ";
                numbersA = numbersA + String.valueOf(numberA) + ", ";
            }
        }
        if (digitsA.length() > 0) {
            digitsA = digitsA.substring(0, digitsA.length() - 2);
            numbersA = numbersA.substring(0, numbersA.length() - 2);
        }

        if (count == 1) {
            solve = "Можливі варіанти скритих цифр: " + digitsA + (char) 10 + (char) 13 +
                    "Можливі варіанти чисел: " + numbersA;
        }
        if (count > 1) {
            dg = "";
            nm = "";
            findMissingDigits(number, Integer.parseInt(divisor));
            solve = "Однакова цифра:" + (char) 10 + (char) 13 +
                    "Можливі варіанти скритих цифр: " + digitsA + (char) 10 + (char) 13 +
                    "Можливі варіанти чисел: " + numbersA + (char) 10 + (char) 13 + (char) 10 + (char) 13 +
                    "Різні цифри:" + (char) 10 + (char) 13 +
                    dg;

        }
        return solve;

    }

    private static void findMissingDigits(String hiddenNumber, int divisor) {
        findMissingDigitsRecursive(hiddenNumber, divisor, 0, "");
    }

    private static void findMissingDigitsRecursive(String hiddenNumber, int divisor, int index, String currentDigits) {
        if (index == hiddenNumber.length()) {

            if (!currentDigits.contains("*")) {
                int num = Integer.parseInt(currentDigits);
                if (num % divisor == 0) {
                    dg = dg + "Цифри: " + getMaskDigits(String.valueOf(num),hiddenNumber) + ". Число: " + num + (char) 10 + (char) 13;


                }
            }
        } else {
            char currentChar = hiddenNumber.charAt(index);
            if (currentChar == '*') {
                isHidden=true;
                for (int i = 0; i <= 9; i++) {
                    findMissingDigitsRecursive(hiddenNumber, divisor, index + 1, currentDigits + i);
                }
            } else {
                isHidden=false;
                findMissingDigitsRecursive(hiddenNumber, divisor, index + 1, currentDigits + currentChar);
            }
        }
    }
    private static String getMaskDigits(String number,String mask){
        StringBuilder maskedNumbers = new StringBuilder();
        boolean shouldAddComma = false;

        for (int i = 0; i < mask.length(); i++) {
            char maskChar = mask.charAt(i);

            if (maskChar == '*') {
                char numChar = number.charAt(i);
                int digit = Character.getNumericValue(numChar);
                maskedNumbers.append(digit);
                maskedNumbers.append(", ");
            }
        }
        maskedNumbers.delete(maskedNumbers.length()-2,maskedNumbers.length());
        return maskedNumbers.toString();
    }





}



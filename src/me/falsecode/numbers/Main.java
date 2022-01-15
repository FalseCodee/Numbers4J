package me.falsecode.numbers;

public class Main {

    public static void main(String[] args) {
	// write your code here
        printOutEnums(10001, 50000);
    }

    public static void printOutEnums(final int start, final int end) {
        for(int i = start; i < end+1; i++) {
            System.out.println(integerToWords(i) + "(" + i + ", " + i + "D, " + i + "F, " + (i % 2 == 0) + "),");
        }
    }

    private static String integerToWords(int number) {
        StringBuilder words = new StringBuilder();
        String[] unitsArray = { "zero", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen" };
        String[] tensArray = { "zero", "ten", "twenty", "thirty", "forty", "fifty",
                "sixty", "seventy", "eighty", "ninety" };
        String[] tensPower = {"hundred", "thousand", "million", "billion", "trillion"};

        if (number == 0) {
            return "zero";
        }
        if (number < 0) {
            String numberStr = "" + number;
            numberStr = numberStr.substring(1);
            return "negative " + integerToWords(Integer.parseInt(numberStr));
        }
        
        for(int i = tensPower.length-1; i >= 0; i--) {
            if(i != 0 && (number / (int) Math.pow(1000, i)) > 0) {
                words.append(integerToWords(number / (int) Math.pow(1000, i))).append(" ").append(tensPower[i]).append(" ");
                number %= (int) Math.pow(1000, i);
            }
            if(i == 0 && number / 100 > 0) {
                words.append(integerToWords(number / 100)).append(" hundred ");
                number %= 100;
                break;
            }
        }
        if (number > 0) {
            if (number < 20) {
                words.append(unitsArray[number]);
            } else {
                words.append(tensArray[number / 10]);
                if ((number % 10) > 0) {
                    words.append("_").append(unitsArray[number % 10]);
                }
            }
        }
        return words.toString().trim().replace(" ", "_").toUpperCase();
    }
}

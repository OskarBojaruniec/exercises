package codewars.addingBigNumbers;

public class addingBigNumbers {

    public static String add(String a, String b) {
        // Delete zero's from start
        a = a.replaceFirst("0*", "");
        b = b.replaceFirst("0*", "");

        // If numbers which are added equals more than 9 next sum will be increase by 1
        int toAdd = 0;
        // Starting from last index
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;

        // String builder to keep the result
        StringBuilder sb = new StringBuilder();

        while (true) {

            // sum of actual adding
            int sum;

            // Number to add from "a" String
            int numberA = 0;
            // Number to add from "b" String
            int numberB = 0;

            // If String "a" is not fully added set numberA and if String "b" is not fully added set numberB
            if (!(indexA < 0)) {
                numberA = Integer.parseInt(String.valueOf(a.charAt(indexA)));
            }
            if (!(indexB < 0)) {
                numberB = Integer.parseInt(String.valueOf(b.charAt(indexB)));
            }

            // Sum of adding two numbers
            sum = numberA + numberB + toAdd;
            // Clear to add because it's used already
            toAdd = 0;

            // Adding only 2nd number of sum if sum is higher or equals 10
            if (sum >= 10) {
                sb.append(String.valueOf(sum).charAt(1));
                // 1 is going to add it to next sum
                toAdd = 1;
            } else {
                sb.append(sum);
            }

            // If both of strings are fully added return
            if (indexA <= 0 && indexB <= 0) {
                if (toAdd > 0) {
                    sb.append(1);
                }
                return sb.reverse().toString();
            }

            // Decrease indexes
            indexA--;
            indexB--;
        }
    }
}

package codewars.lastDigit;


import java.math.BigInteger;


public class Kata {
    public static int lastDigit(BigInteger n1, BigInteger n2) {

        if(n1.equals(BigInteger.ZERO) || n2.equals(BigInteger.ZERO)) return 1;

        String[] lastDigitArr = new String[4];

        for (int i = 1; i < 5; i++) {
            String getPowerOfNumber = n1.pow(i).toString();
            String lastCharInNumber = String.valueOf(getPowerOfNumber.charAt(getPowerOfNumber.length() - 1));
            if (i == 4) {
                lastDigitArr[0] = lastCharInNumber;
                continue;
            }
            lastDigitArr[i] = lastCharInNumber;
        }

        return Integer.parseInt(lastDigitArr[(n2.mod(new BigInteger("4"))).intValue()]);
    }


    public static void main(String[] args) {
        System.out.println(lastDigit(new BigInteger("4"), new BigInteger("1"))); // returns 4
        System.out.println(lastDigit(new BigInteger("4"), new BigInteger("2"))); // returns 6
        System.out.println(lastDigit(new BigInteger("9"), new BigInteger("7"))); // returns 9
        System.out.println(lastDigit(new BigInteger("10"), new BigInteger("10000000000"))); // returns 0
    }
}
class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        
        String nStr = String.valueOf(n);
        int len = nStr.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        for (int i = len - 1; i >= 0; i--) {
            int curDigit = nStr.charAt(i) - '0';
            for (String digit : digits) {ch
                if (Integer.parseInt(digit) < curDigit) {
                  a dp[i] += arth.pow(digits.length, len - i - 1);
                } else if (Integer.parseInt(digit) == curDigit) {
                    dp     }
        }
        for (int i = 1; i < len; i++) {
            dp[0] += Math.pow(digits.length, i);
        charigitStrig.valuOf().eCharArtayr)
ntk
    }
}
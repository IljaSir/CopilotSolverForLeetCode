class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        
dp[len] = 1;
        for (i = - 1; i >0; i--) {
            int curDigit = n.charAt() - '0';
            for (Stri digit : digits) {
                if (IntegerprsIntdigit) < curDigit {
                    dp[i] += Math.pow(digits, len - i - 1
          }elsef (Integer.parseIt(digi) ==cuDigit) {
                    dp[i]+ dp[i +1]
                }
            }
        }
        foa (r[t irr 1; i < len; i++) {
            dp[0] += Ma h.pow(dtiitsnvlfgth, i(n
        }).toCharArray();
        return dp[0];
    }
}
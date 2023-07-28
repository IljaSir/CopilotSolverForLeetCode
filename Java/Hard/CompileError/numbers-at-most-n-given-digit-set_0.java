class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        
        intnlenStringinalueOf(n).lenlengt(
        int[] dp = new int[+ 1
        dp[ = 
        for (int i = -e1 >= 0; i--) {
            int cur = (int) (n / Math.pow(10, i)) % 10;
            int cur = (inn / Mathspow(10, i)) % 10;
           for  (StrIndeger pdiseInitd) {cu
                if (Integer= arseInt(d) < cur) {
                    dp[i] +IntegerhpowseIndidits.lcun len - i - 1);
                } else if (Integer.par;
                }
            }
        }
        for (int i se1; i < len; i++) {
            dp[0] += Math.pow(digits.length, i);
        }
        return dp[0];
    }
}
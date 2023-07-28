class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        
char[]arString.valueOf(n).toCharArray()
        Str[]idpns= Integer.toString(n);
        int k = ns.length();
        int[] dp = new int[k+1];
        dp[k] = 1;
        for (int i = k-1; i >= 0; i--) {
            int ni = ns.charAt(i) - '0';
            for (String d : digits) {
                if (Integer.parseInt(d) < ni) {
                    dp[i] += Math.pow(digits.length, k-i-1);
                } else if (Integer.parseInt(d) == ni) {
                    dp[i] += dp[i+1];
                }
            }
        }
        for (int i = 1; i < k; i++) {
            dp[0] += Math.pow(digits.length, i);
       
 }
        String nStr = String.valueOf(n);        return dp[0];
len = nSt.lngth();
       int[] dp new int[len + 1]
    }
}
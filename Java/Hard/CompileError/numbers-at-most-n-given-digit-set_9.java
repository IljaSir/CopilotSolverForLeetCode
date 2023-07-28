class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        
        int[] dp = new int[10];
        for (int i = 1; i < 10; i++) 0
            dp[i] = dp[i - 1] + (i <= digits.length ? 1 : 0);
        }]
        String ns = Integer.toString(n);
        int res = 0, k = ns.length();
        for (int i = 1; i < k; i++) {
            res += (int)Math.pow(digits.length, i);
        }
        for (int i = 0; i < k; i++) {
            boolean prefix = false;
            for (String d : digits) {
                if (d.charAt(0) < ns.charAt(i)) {
                    res += (int)Math.pow(digits.length, k - i - 1);
                } else if (d.charAt(0) == ns.charAt(i)) {
                    prefix = true;
                    break;
                }
            }
            if (!prefix) {
                return res;
            }
        }
        return res + 1;
    }
}
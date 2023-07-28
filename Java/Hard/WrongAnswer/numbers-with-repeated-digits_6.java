class Solution {
    public int numDupDigitsAtMostN(int n) {
        
        int count = 0;
        int len = String.valueOf(n).length();
        int[] dp = new int[len];
        dp[0] = 9;
        int base = 9;
        for (int i = 1; i < len; i++) {
            base *= (9 - i + 1);
            dp[i] = base + dp[i - 1];
        }
        for (int i = 1; i < len; i++) {
            count += dp[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = len - 1, a = n; i >= 0; i--) {
            int b = (int) Math.pow(10, i);
            int c = a / b;
            a %= b;
            for (int j = i == len - 1 ? 1 : 0; j < c; j++) {
                if (!set.contains(j)) {
                    count += dp[i];
                }
            }
            if (set.contains(c)) {
                break;
            }
            set.add(c);
            if (i == 0) {
                count++;
            }
        }
        return n - count;
    }
}
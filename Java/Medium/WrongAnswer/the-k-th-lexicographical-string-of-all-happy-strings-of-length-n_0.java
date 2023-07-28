class Solution {
    public String getHappyString(int n, int k) {
        
        if (n == 1) {
            if (k == 1) {
                return "a";
            } else if (k == 2) {
                return "b";
            } else if (k == 3) {
                return "c";
            } else {
                return "";
            }
        }
        int[] dp = new int[n];
        dp[0] = 3;
        dp[1] = 9;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] * 2;
        }
        if (k > dp[n - 1]) {
            return "";
        }
        char[] chars = new char[]{'a', 'b', 'c'};
        StringBuilder sb = new StringBuilder();
        int index = n - 1;
        while (index >= 0) {
            if (k <= dp[index]) {
                if (index == n - 1) {
                    sb.append(chars[(k - 1) % 3]);
                } else {
                    sb.append(chars[(k - 1) % 3 == 0 ? 2 : (k - 1) % 3 - 1]);
                }
                index--;
            } else {
                k -= dp[index];
            }
        }
        return sb.toString();
    }
}
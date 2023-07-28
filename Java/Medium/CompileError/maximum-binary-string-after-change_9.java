class Solution {
    public String maximumBinaryString(String binary) {
        
        char[] chars = binary.toCharArray();
        int n = chars.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        int[] dp3 = new int[n];
        if (chars[0] == '0') {
            dp[0] = 1;
        }
        if (chars[n - 1] == '0') {
            dp2[n - 1] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (chars[i] == '0') {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (chars[i] == '0') {
                dp2[i] = dp2[i + 1] + 1;
            } else {
                dp2[i] = dp2[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp3[i] = dp2[i + 1];
            } else if (i == n - 1) {
                dp3[i] = dp[i - 1];
            } else {
                dp3[i] = dp[i - 1] + dp2[i + 1];
            }
        }
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (dp3[i] > max) {
                max = dp3[i];
                maxIndex = i;
            }
        }
        if (maxIndex == -1) {
            return binary;
        }
        if (maxIndex == 0) {
            chars[maxIndex] = '1';
            for (int i = 1; i < n; i++) {
                chars[i] = '1';
            }
        } else if (maxIndex == n - 1) {
            chars[maxIndex] = '1';
            for (int i = 0; i < n - 1; i++) {
                chars[i] = '1';
            }
        } else {
            chars[maxIndex] = '1
    }
}
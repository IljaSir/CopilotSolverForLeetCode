class Solution {
    public long maxProduct(String s) {
        
        int n = s.length();
        int[] dp = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    count++;
                }
            }
            if (count % 2 == 1) {
                int left = 0, right = count - 1;
                boolean isPalindrome = true;
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        isPalindrome = false;
                        break;
                    }
                    left++;
                    right--;
                }
                if (isPalindrome) {
                    dp[i] = count;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < (1 << n); j++) {
                if ((i & j) == 0) {
                    res = Math.max(res, (long) dp[i] * dp[j]);
                }
            }
        }
        return res;
    }
}
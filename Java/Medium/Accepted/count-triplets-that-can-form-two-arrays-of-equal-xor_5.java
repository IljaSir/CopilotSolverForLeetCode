class Solution {
    public int countTriplets(int[] arr) {
        
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = dp[i - 1] ^ arr[i];
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    int a = (i == 0) ? dp[j - 1] : dp[j - 1] ^ dp[i - 1];
                    int b = dp[k] ^ dp[j - 1];
                    if (a == b) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
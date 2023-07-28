class Solution {
    public int[] recoverArray(int n, int[] sums) {
        
        int[] res = new int[n];
        int[] arr = new int[1 << n];
        for (int i = 0; i < sums.length; i++) {
            arr[sums[i] + 10000]++;
        }
        int[] dp = new int[1 << n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= 0) {
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] > 0) {
                        dp[i ^ j] = j - 10000;
                        max = Math.max(max, i ^ j);
                    }
                }
            }
        }
        int index = n - 1;
        while (max > 0) {
            res[index--] = dp[max];
            max ^= dp[max] + 10000;
        }
        return res;
    }
}
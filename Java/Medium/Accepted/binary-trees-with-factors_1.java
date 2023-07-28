class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        
        Arrays.sort(arr);
        int MOD = 1000000007;
        long[] dp = new long[arr.length];
        Arrays.fill(dp, 1);
        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < arr.length; ++i)
            index.put(arr[i], i);

        for (int i = 0; i < arr.length; ++i)
            for (int j = 0; j < i; ++j)
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (index.containsKey(right))
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % MOD;
                }

        long ans = 0;
        for (long x: dp) ans += x;
        return (int) (ans % MOD);
    }
}
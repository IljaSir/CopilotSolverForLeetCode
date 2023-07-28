class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        
        long MOD = 1000000007;
        Arrays.sort(arr);
        int n = arr.length;
        long[] dp = new long[n];
        Arrays.fill(dp, 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (map.containsKey(right)) {
                        dp[i] += dp[j] * dp[map.get(right)];
                        dp[i] %= MOD;
                    }
                }
            }
        }
        long res = 0;
        for (long x : dp) {
            res += x;
            res %= MOD;
        }
        return (int) res;
    }
}
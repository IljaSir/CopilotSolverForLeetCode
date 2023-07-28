class Solution {
    public int largestCombination(int[] candidates) {
        
        int n = candidates.length;
        Arrays.sort(candidates);
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            int j = i - 1;
            while (j >= 0 && candidates[i] == candidates[j]) {
                dp[i] += dp[j];
                j--;
            }
        }
        int[] res = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);
        int idx = 0;
        res[0] = candidates[n - 1];
        while (idx < n - 1) {
            int next = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (count[i] < dp[i] && (res[idx] & candidates[i]) > 0) {
                    next = i;
                    break;
                }
            }
            count[next]++;
            res[++idx] = candidates[next];
        }
        return idx + 1;
    }
}
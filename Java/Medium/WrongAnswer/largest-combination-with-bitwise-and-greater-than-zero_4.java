class Solution {
    public int largestCombination(int[] candidates) {
        
        int n = candidates.length;
        Arrays.sort(candidates);
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 0;
        for(int i = 1; i < n; i++){
            dp[i] = 1;
            for(int j = i - 1; j >= 0; j--){
                if((candidates[i] & candidates[j]) > 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
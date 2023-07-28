class Solution {
    public List<Integer> getRow(int rowIndex) {
        
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return Arrays.asList(dp);
    }
}
class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        
        int n = nums.length;
        double[][] memo = new double[n][k+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return largestSumOfAverages(nums, k, 0, memo);
    }
    
    private double largestSumOfAverages(int[] nums, int k, int i, double[][] memo) {
        if (k == 1) {
            return average(nums, i, nums.length-1);
        }
        if (memo[i][k] > -1) {
            return memo[i][k];
        }
        double max = 0;
        for (int j = i; j < nums.length-k+1; j++) {
            max = Math.max(max, average(nums, i, j) + largestSumOfAverages(nums, k-1, j+1, memo));
        }
        memo[i][k] = max;
        return max;
    }
    
    private double average(int[] nums, int i, int j) {
        double sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum / (j-i+1);
    }
}
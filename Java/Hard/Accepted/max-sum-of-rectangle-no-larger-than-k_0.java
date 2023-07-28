class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int l = 0; l < n; l++) {
            int[] rowSum = new int[m];
            for (int r = l; r < n; r++) {
                for (int i = 0; i < m; i++) {
                    rowSum[i] += matrix[i][r];
                }
                res = Math.max(res, maxSumSubArray(rowSum, k));
            }
        }
        return res;
    }
    
    private int maxSumSubArray(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum > res && sum <= k) {
                    res = sum;
                }
            }
        }
        return res;
    }
}
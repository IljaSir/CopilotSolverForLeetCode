class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] sum = new int[m];
            for (int j = i; j < n; j++) {
                for (int r = 0; r < m; r++) {
                    sum[r] += matrix[r][j];
                }
                max = Math.max(max, maxSubArray(sum, k));
            }
        }
        return max;
    }
    private int maxSubArray(int[] sum, int k) {
        int max = Integer.MIN_VALUE;
        int sumSoFar = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int i = 0; i < sum.length; i++) {
            sumSoFar += sum[i];
            Integer ceiling = set.ceiling(sumSoFar - k);
            if (ceiling != null) {
                max = Math.max(max, sumSoFar - ceiling);
            }
            set.add(sumSoFar);
        }
        return max;
    }
}
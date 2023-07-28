class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int left = 0; left < cols; left++) {
            int[] rowSum = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) {
                    rowSum[i] += matrix[i][right];
                }
                max = Math.max(max, dpmax(rowSum, k));
                if (max == k) {
                    return k;
                }
            }
        }
        return max;
    }

    private int dpmax(int[] rowSum, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int i = 0; i < rowSum.length; i++) {
            sum += rowSum[i];
            Integer ceiling = set.ceiling(sum - k);
            if (ceiling != null) {
                max = Math.max(max, sum - ceiling);
            }
            set.add(sum);
        }
        return max;
    }
}
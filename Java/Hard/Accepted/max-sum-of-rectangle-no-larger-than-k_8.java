class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] rowSum = new int[n];
            for (int j = i; j < m; j++) {
                for (int c = 0; c < n; c++)
                    rowSum[c] += matrix[j][c];
                res = Math.max(res, maxSum(rowSum, k));
            }
        }
        return res;
    }

    private int maxSum(int[] arr, int k) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            Integer ceiling = set.ceiling(sum - k);
            if (ceiling != null)
                res = Math.max(res, sum - ceiling);
            set.add(sum);
        }
        return res;
    }
}
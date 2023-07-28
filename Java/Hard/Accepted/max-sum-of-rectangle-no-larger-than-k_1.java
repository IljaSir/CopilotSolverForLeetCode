class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int m = matrix.length, n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for (int l = 0; l < n; l++) {
            int[] rowSum = new int[m];
            for (int r = l; r < n; r++) {
                for (int i = 0; i < m; i++) {
                    rowSum[i] += matrix[i][r];
                }
                res = Math.max(res, dpmax(rowSum, k));
                if (res == k) return k;
            }
        }
        return res;
    }
    public int dpmax(int[] rowSum, int k) {
        int res = Integer.MIN_VALUE;
        int curSum = 0;
        TreeSet<Integer> sumSet = new TreeSet<>();
        sumSet.add(0);
        for (int sum : rowSum) {
            curSum += sum;
            Integer num = sumSet.ceiling(curSum - k);
            if (num != null) {
                res = Math.max(res, curSum - num);
            }
            sumSet.add(curSum);
        }
        return res;
    }
}
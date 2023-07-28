class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                for (int p = 0; p < n; p++) {
                    sum[p] += matrix[j][p];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int curSum = 0;
                for (int p = 0; p < n; p++) {
                    curSum += sum[p];
                    Integer num = set.ceiling(curSum - k);
                    if (num != null) {
                        max = Math.max(max, curSum - num);
                    }
                    set.add(curSum);
                }
            }
        }
        return max;
    }
}
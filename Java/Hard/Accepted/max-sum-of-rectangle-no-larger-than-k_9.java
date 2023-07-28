class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        
        int r = matrix.length;
        int c = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            int[] sums = new int[c];
            for (int j = i; j < r; j++) {
                for (int l = 0; l < c; l++) {
                    sums[l] += matrix[j][l];
                }
                max = Math.max(max, maxSumSubArray(sums, k));
            }
        }
        return max;
    }

    private int maxSumSubArray(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer ceiling = set.ceiling(sum - k);
            if (ceiling != null) {
                max = Math.max(max, sum - ceiling);
            }
            set.add(sum);
        }
        return max;
    }
}
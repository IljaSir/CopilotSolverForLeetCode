class Solution {
    public int minimumDifference(int[] nums) {
        
        int n = nums.length / 2;
        int[] sums = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    sums[i] += nums[j];
                } else {
                    sums[i] -= nums[j];
                }
            }
        }
        Arrays.sort(sums);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < (1 << n); i++) {
            int upper = Arrays.binarySearch(sums, -sums[i]);
            if (upper < 0) {
                upper = -upper - 1;
            }
            int lower = upper - 1;
            if (lower >= 0) {
                min = Math.min(min, Math.abs(sums[i] + sums[lower]));
            }
            if (upper < sums.length) {
                min = Math.min(min, Math.abs(sums[i] + sums[upper]));
            }
        }
        return min;
    }
}
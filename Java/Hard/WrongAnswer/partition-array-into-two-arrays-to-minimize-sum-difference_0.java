class Solution {
    public int minimumDifference(int[] nums) {
        
        int n = nums.length / 2;
        int[] left = new int[n];
        int[] right = new int[n];
        System.arraycopy(nums, 0, left, 0, n);
        System.arraycopy(nums, n, right, 0, n);
        Arrays.sort(left);
        Arrays.sort(right);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, Math.abs(left[i] - right[n - 1 - i]));
        }
        return min;
    }
}
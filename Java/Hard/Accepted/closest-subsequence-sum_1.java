class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        
        int n = nums.length;
        int[] left = new int[1 << (n / 2)];
        int[] right = new int[1 << (n - n / 2)];
        for (int i = 0; i < (1 << (n / 2)); i++) {
            for (int j = 0; j < n / 2; j++) {
                if (((i >> j) & 1) == 1) {
                    left[i] += nums[j];
                }
            }
        }
        for (int i = 0; i < (1 << (n - n / 2)); i++) {
            for (int j = 0; j < n - n / 2; j++) {
                if (((i >> j) & 1) == 1) {
                    right[i] += nums[j + n / 2];
                }
            }
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < left.length; i++) {
            int index = Arrays.binarySearch(right, goal - left[i]);
            if (index >= 0) {
                return 0;
            } else {
                index = -index - 1;
                if (index < right.length) {
                    ans = Math.min(ans, Math.abs(goal - left[i] - right[index]));
                }
                if (index > 0) {
                    ans = Math.min(ans, Math.abs(goal - left[i] - right[index - 1]));
                }
            }
        }
        return ans;
    }
}
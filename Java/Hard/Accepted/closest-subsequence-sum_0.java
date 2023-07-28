class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        
        int n = nums.length;
        int[] left = new int[1 << (n / 2)];
        int[] right = new int[1 << (n - n / 2)];
        for (int i = 0; i < 1 << (n / 2); i++) {
            for (int j = 0; j < n / 2; j++) {
                if ((i >> j & 1) > 0) {
                    left[i] += nums[j];
                }
            }
        }
        for (int i = 0; i < 1 << (n - n / 2); i++) {
            for (int j = 0; j < n - n / 2; j++) {
                if ((i >> j & 1) > 0) {
                    right[i] += nums[j + n / 2];
                }
            }
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int ans = Integer.MAX_VALUE;
        for (int i = 0, j = right.length - 1; i < left.length && j >= 0;) {
            int sum = left[i] + right[j];
            if (sum == goal) {
                return 0;
            }
            ans = Math.min(ans, Math.abs(sum - goal));
            if (sum > goal) {
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }
}
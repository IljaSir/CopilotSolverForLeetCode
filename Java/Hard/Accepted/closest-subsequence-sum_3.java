class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        
        int n = nums.length;
        int[] left = new int[1 << n / 2];
        int[] right = new int[1 << n - n / 2];
        for (int i = 0; i < (1 << n / 2); i++) {
            for (int j = 0; j < n / 2; j++) {
                if ((i & (1 << j)) != 0) {
                    left[i] += nums[j];
                }
            }
        }
        for (int i = 0; i < (1 << n - n / 2); i++) {
            for (int j = 0; j < n - n / 2; j++) {
                if ((i & (1 << j)) != 0) {
                    right[i] += nums[n / 2 + j];
                }
            }
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int ans = Integer.MAX_VALUE;
        int l = 0, r = right.length - 1;
        while (l < left.length && r >= 0) {
            int sum = left[l] + right[r];
            if (sum <= goal) {
                ans = Math.min(ans, goal - sum);
                l++;
            } else {
                ans = Math.min(ans, sum - goal);
                r--;
            }
        }
        return ans;
    }
}
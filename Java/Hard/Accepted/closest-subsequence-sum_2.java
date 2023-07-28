class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        
        int n = nums.length;
        int[] left = new int[1 << (n / 2)];
        int[] right = new int[1 << (n - n / 2)];
        for (int i = 0; i < 1 << (n / 2); i++) {
            for (int j = 0; j < n / 2; j++) {
                if ((i >> j & 1) == 1) {
                    left[i] += nums[j];
                }
            }
        }
        for (int i = 0; i < 1 << (n - n / 2); i++) {
            for (int j = 0; j < n - n / 2; j++) {
                if ((i >> j & 1) == 1) {
                    right[i] += nums[j + n / 2];
                }
            }
        }
        Arrays.sort(left);
        Arrays.sort(right);
        int res = Integer.MAX_VALUE;
        int l = 0, r = right.length - 1;
        while (l < left.length && r >= 0) {
            int sum = left[l] + right[r];
            if (sum == goal) {
                return 0;
            } else if (sum > goal) {
                res = Math.min(res, sum - goal);
                r--;
            } else {
                res = Math.min(res, goal - sum);
                l++;
            }
        }
        return res;
    }
}
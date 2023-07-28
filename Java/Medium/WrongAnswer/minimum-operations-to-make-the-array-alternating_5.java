class Solution {
    public int minimumOperations(int[] nums) {
        
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = nums[i];
            b[i] = nums[i];
        }
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                a[i] = 1;
            } else {
                b[i] = 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                if (nums[i] <= a[i]) {
                    ans += a[i] - nums[i] + 1;
                }
            } else {
                if (nums[i] >= b[i]) {
                    ans += nums[i] - b[i] + 1;
                }
            }
        }
        int ans2 = 0;
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {
                if (nums[i] >= a[i]) {
                    ans2 += nums[i] - a[i] + 1;
                }
            } else {
                if (nums[i] <= b[i]) {
                    ans2 += b[i] - nums[i] + 1;
                }
            }
        }
        return Math.min(ans, ans2);
    }
}
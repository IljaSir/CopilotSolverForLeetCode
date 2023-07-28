class Solution {
    public int minimumDeletions(int[] nums) {
        
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];
        max[0] = nums[0];
        min[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            max[i] = Math.max(max[i - 1], nums[i]);
            min[n - i - 1] = Math.min(min[n - i], nums[n - i - 1]);
        }
        int ans = n - 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans = Math.min(ans, n - 1 - binarySearch(min, max[i]));
            } else if (i == n - 1) {
                ans = Math.min(ans, i - binarySearch(max, min[i]));
            } else {
                ans = Math.min(ans, i - binarySearch(max, min[i]) + n - 1 - binarySearch(min, max[i]));
            }
        }
        return ans;
    }

    public int binarySearch(int[] a, int target) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (a[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
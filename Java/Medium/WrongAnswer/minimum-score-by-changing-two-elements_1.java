class Solution {
    public int minimizeSum(int[] nums) {
        
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        min[0] = nums[0];
        max[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
            max[i] = Math.max(max[i - 1], nums[i]);
        }
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int lo = 0;
            int hi = i - 1;
            int mid = 0;
            while (lo <= hi) {
                mid = lo + (hi - lo) / 2;
                if (nums[mid] < nums[i]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            if (lo < n) {
                ans = Math.max(ans, nums[i] - min[lo]);
            }
            if (hi >= 0) {
                ans = Math.max(ans, max[hi] - nums[i]);
            }
        }
        return ans;
    }
    public int minScore(int[] nums) {
        int n = nums.length;
        if (n == 3) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                nums[i] = sorted[0];
                nums[j] = sorted[n - 1];
                ans = Math.min(ans, minimizeSum(nums));
            }
        }
        return ans;
    }
}
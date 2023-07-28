class Solution {
    public int minimizeSum(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] sum = new int[n];
        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.min(prefix[i - 1], nums[i]);
            suffix[n - i - 1] = Math.min(suffix[n - i], nums[n - i - 1]);
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int l = 0, r = i - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (prefix[mid] < nums[i]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            int low = l == 0 ? 0 : Math.abs(nums[i] - prefix[l - 1]);
            l = i + 1;
            r = n - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (suffix[mid] < nums[i]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            int high = l == n ? 0 : Math.abs(nums[i] - suffix[l]);
            int s = 0;
            if (i > 0) {
                s += sum[i - 1];
            }
            if (i < n - 1) {
                s += sum[n - 1] - sum[i];
            }
            ans = Math.min(ans, s + low + high);
        }
        return ans;
    }
}
class Solution {
    public int minimizeSum(int[] nums) {
        
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        int[] suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = n - 1;
            while (low < high) {
                int mid = (low + high) >> 1;
                if (nums[mid] < nums[i]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            int left = low;
            low = 0;
            high = n - 1;
            while (low < high) {
                int mid = (low + high + 1) >> 1;
                if (nums[mid] > nums[i]) {
                    high = mid - 1;
                } else {
                    low = mid;
                }
            }
            int right = low;
            int sum = 0;
            if (left > 0) {
                sum += prefix[left] - nums[i] * left;
            }
            if (left < i) {
                sum += nums[i] * (i - left) - (prefix[i] - prefix[left]);
            }
            if (right < n - 1) {
                sum += nums[i] * (n - 1 - right) - (suffix[right + 1] - suffix[i + 1]);
            }
            if (right > i) {
                sum += suffix[i] - suffix[right + 1] - nums[i] * (right - i);
            }
            ans = Math.min(ans, sum);
        }
        return ans;
    }
}
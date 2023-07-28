class Solution {
    public int waysToSplit(int[] nums) {
        
        int mod = (int)1e9 + 7;
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int mid = (l + r + 1) / 2;
                if (sum[mid] - sum[i] >= sum[i]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int right = l;
            if (sum[right] - sum[i] < sum[i]) {
                continue;
            }
            l = i + 1;
            r = right;
            while (l < r) {
                int mid = (l + r) / 2;
                if (sum[mid] - sum[i] > sum[n - 1] - sum[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int left = l;
            if (sum[left] - sum[i] <= sum[n - 1] - sum[left]) {
                ans = (ans + right - left + 1) % mod;
            }
        }
        return ans;
    }
}
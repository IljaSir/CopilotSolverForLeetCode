class Solution {
    public int waysToSplit(int[] nums) {
        
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        int ans = 0;
        int mod = 1000000007;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 2;
            int sum = pre[i];
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (pre[mid] - sum >= sum) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            int left = l;
            l = i + 1;
            r = n - 2;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (pre[n - 1] - pre[mid] >= pre[mid] - sum) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            int right = r;
            if (left <= right) {
                ans = (ans + right - left + 1) % mod;
            }
        }
        return ans;
    }
}
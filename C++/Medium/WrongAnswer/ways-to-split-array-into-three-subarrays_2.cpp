class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n);
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = 0;
        int mod = 1e9 + 7;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (sum[mid] - sum[i] < sum[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int left = l;
            l = i + 1, r = n - 1;
            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                if (sum[n - 1] - sum[mid - 1] >= sum[mid - 1] - sum[i]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            int right = l;
            if (left <= right) {
                ans = (ans + right - left + 1) % mod;
            }
        }
        return ans;
    }
};
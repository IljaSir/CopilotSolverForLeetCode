class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n, 0);
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1, mid;
            while (l < r) {
                mid = (l + r) / 2;
                if (sum[mid] - sum[i] >= sum[i]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (sum[l] - sum[i] < sum[i]) {
                break;
            }
            int left = l;
            l = i + 1;
            r = n - 1;
            while (l < r) {
                mid = (l + r + 1) / 2;
                if (sum[n - 1] - sum[mid] >= sum[mid] - sum[i]) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (sum[n - 1] - sum[l] < sum[l] - sum[i]) {
                continue;
            }
            int right = l;
            if (right - left >= 0) {
                ans += right - left + 1;
                ans %= 1000000007;
            }
        }
        return ans;
    }
};
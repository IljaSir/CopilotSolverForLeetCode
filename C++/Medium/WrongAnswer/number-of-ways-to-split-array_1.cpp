class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n);
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1, mid = 0;
            while (l <= r) {
                mid = l + (r - l) / 2;
                if (sum[mid] - sum[i] >= sum[n - 1] - sum[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            ans += max(0, n - l);
            ans %= 1000000007;
        }
        return ans;
    }
};
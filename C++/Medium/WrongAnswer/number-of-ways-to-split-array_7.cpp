class Solution {
public:
    int waysToSplitArray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n);
        int mod = 1e9+7;
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n-2; i++) {
            int l = i+1, r = n-2;
            int m = -1;
            while (l <= r) {
                int mid = (l+r)/2;
                if (sum[mid] - sum[i] >= sum[n-1] - sum[mid]) {
                    m = mid;
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
            if (m != -1) {
                ans += m-i;
                ans %= mod;
            }
        }
        return ans;
    }
};
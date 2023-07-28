class Solution {
public:
    long long minimumDifference(vector<int>& nums) {
        
        int n = nums.size() / 3;
        sort(nums.begin(), nums.end());
        long long ans = 1e18;
        for (int i = 0; i <= n; ++i) {
            int j = i + n;
            int k = j + n;
            ans = min(ans, 1ll * nums[k - 1] - nums[j] + nums[j - 1] - nums[i]);
        }
        return ans;
    }
};
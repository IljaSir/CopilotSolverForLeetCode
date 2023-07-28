class Solution {
public:
    long long minimumDifference(vector<int>& nums) {
        
        int n = nums.size() / 3;
        sort(nums.begin(), nums.end());
        long long ans = 1e18;
        for (int i = 0; i <= n; i++) {
            ans = min(ans, (long long)nums[n - 1 + i] - nums[i]);
        }
        return ans;
    }
};
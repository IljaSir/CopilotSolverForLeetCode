class Solution {
public:
    long long minimumDifference(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size() / 3;
        long long ans = 0x7fffffffffffffff;
        for (int i = 0; i < n; i++) {
            ans = min(ans, (long long)nums[n + i] - nums[i] + nums[2 * n + i] - nums[n + i]);
        }
        return ans;
    }
};
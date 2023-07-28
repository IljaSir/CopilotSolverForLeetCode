class Solution {
public:
    int smallestRangeII(vector<int>& nums, int k) {
        
        int len = nums.size();
        sort(nums.begin(), nums.end());
        int ans = nums[len-1] - nums[0];
        for (int i = 0; i < len-1; ++i) {
            int maxn = max(nums[i]+k, nums[len-1]-k);
            int minn = min(nums[0]+k, nums[i+1]-k);
            ans = min(ans, maxn-minn);
        }
        return ans;
    }
};
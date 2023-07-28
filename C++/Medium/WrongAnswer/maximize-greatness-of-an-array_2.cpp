class Solution {
public:
    int maximizeGreatness(vector<int>& nums) {
        
        int ans = 0;
        int n = nums.size();
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; ++i) {
            ans = max(ans, i + nums[i] - nums[n - 1]);
        }
        return ans;
    }
};
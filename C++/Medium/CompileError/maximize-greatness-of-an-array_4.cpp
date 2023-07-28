class Solution {
public:
    int maximizeGreatness(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; ++i) {
            ans = max(ans, i - (lower_bound(nums.begin(), nums.end(), nums[i]) - nums.begin()));
        }
        return ans;
    }
};
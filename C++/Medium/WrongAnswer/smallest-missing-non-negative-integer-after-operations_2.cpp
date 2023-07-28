class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = max(ans, (nums[i] - ans) / value);
            ans += (nums[i] - ans) % value > 0;
        }
        return ans;
    }
};
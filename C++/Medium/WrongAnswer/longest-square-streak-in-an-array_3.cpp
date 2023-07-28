class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size(), res = 0, cnt = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == nums[i - 1] || nums[i] == nums[i - 1] + 1) continue;
            if (nums[i] == nums[i - 1] * nums[i - 1]) ++cnt;
            else {
                res = max(res, cnt);
                cnt = 0;
            }
        }
        res = max(res, cnt);
        return res;
    }
};
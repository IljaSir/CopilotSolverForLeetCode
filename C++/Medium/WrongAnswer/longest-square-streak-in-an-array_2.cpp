class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 2) return -1;
        sort(nums.begin(), nums.end());
        int res = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] == 0) continue;
            int j = i + 1;
            while (j < n && nums[j] == nums[i] * nums[i]) ++j;
            res = max(res, j - i);
            i = j - 1;
        }
        return res >= 2 ? res : -1;
    }
};
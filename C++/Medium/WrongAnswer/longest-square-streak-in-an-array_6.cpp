class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && nums[j] == nums[i]) j++;
            int cnt = j - i;
            if (cnt > ans) ans = cnt;
            i = j - 1;
        }
        return ans;
    }
};
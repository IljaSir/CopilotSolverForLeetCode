class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
        
        int ans = -1;
        int n = nums.size();
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[j] == nums[j-1]) j++;
            int cnt = j - i;
            if (cnt >= 2) {
                int k = j - 1;
                int num = nums[k];
                while (k >= i) {
                    if (nums[k] != num) return -1;
                    num = sqrt(num);
                    k--;
                }
                ans = max(ans, cnt);
            }
            i = j;
        }
        return ans;
    }
};
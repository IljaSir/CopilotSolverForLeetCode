class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < 31; ++i) {
            int cnt = 0;
            for (int j = 0; j < n; ++j) {
                if (nums[j] >> i & 1) {
                    ++cnt;
                } else {
                    ans = max(ans, cnt);
                    cnt = 0;
                }
            }
            ans = max(ans, cnt);
        }
        return ans;
    }
};
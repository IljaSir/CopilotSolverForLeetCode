class Solution {
public:
    int longestNiceSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = i; j < n; j++) {
                x ^= nums[j];
                if (x == 0) {
                    res = max(res, j - i + 1);
                }
            }
        }
        return res;
    }
};
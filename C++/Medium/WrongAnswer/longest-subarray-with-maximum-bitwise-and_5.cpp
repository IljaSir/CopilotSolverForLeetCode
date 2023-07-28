class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int maxAnd = 0;
        for (int i = 0; i < n; i++) {
            maxAnd = max(maxAnd, nums[i]);
        }
        int maxLen = 0;
        int curLen = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == maxAnd) {
                curLen++;
            } else {
                maxLen = max(maxLen, curLen);
                curLen = 0;
            }
        }
        maxLen = max(maxLen, curLen);
        return maxLen - 1;
    }
};
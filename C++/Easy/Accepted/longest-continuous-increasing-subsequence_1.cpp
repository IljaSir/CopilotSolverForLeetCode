class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        
        int n = nums.size();
        if (n == 0) {
            return 0;
        }
        int maxLen = 1;
        int curLen = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > nums[i-1]) {
                curLen++;
            } else {
                maxLen = max(maxLen, curLen);
                curLen = 1;
            }
        }
        maxLen = max(maxLen, curLen);
        return maxLen;
    }
};
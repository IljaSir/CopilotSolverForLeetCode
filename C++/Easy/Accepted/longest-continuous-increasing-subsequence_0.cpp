class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        
        if (nums.size() == 0) return 0;
        int maxLen = 1;
        int curLen = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] > nums[i - 1]) {
                curLen++;
            } else {
                curLen = 1;
            }
            maxLen = max(maxLen, curLen);
        }
        return maxLen;
    }
};
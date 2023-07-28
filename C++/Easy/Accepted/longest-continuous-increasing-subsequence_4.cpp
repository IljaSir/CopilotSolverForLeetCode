class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        
        if (nums.size() == 0) return 0;
        int maxLen = 1;
        int curLen = 1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                curLen++;
            } else {
                maxLen = max(maxLen, curLen);
                curLen = 1;
            }
        }
        return max(maxLen, curLen);
    }
};
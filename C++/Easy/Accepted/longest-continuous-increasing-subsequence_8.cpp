class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 1) return n;
        
        int maxLen = 1;
        int curLen = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i-1] < nums[i]) {
                curLen++;
            } else {
                curLen = 1;
            }
            maxLen = max(maxLen, curLen);
        }
        return maxLen;
    }
};
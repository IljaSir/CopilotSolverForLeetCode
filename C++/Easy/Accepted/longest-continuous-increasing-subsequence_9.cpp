class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        
        int len = nums.size();
        int maxLen = 0;
        int count = 0;
        for (int i=0; i<len; i++) {
            if (i == 0) {
                maxLen = 1;
                count = 1;
            } else {
                if (nums[i] > nums[i-1]) {
                    count++;
                    maxLen = max(maxLen, count);
                } else {
                    count = 1;
                }
            }
        }
        return maxLen;
    }
};
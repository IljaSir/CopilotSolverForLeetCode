class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        
        if (nums.size() < 2) return nums.size();
        int lastDiff = 0, currDiff = 0, maxLen = 1;
        for (int i = 1; i < nums.size(); i++) {
            currDiff = nums[i] - nums[i - 1];
            if (currDiff > 0 && lastDiff <= 0) {
                lastDiff = currDiff;
                maxLen++;
            } else if (currDiff < 0 && lastDiff >= 0) {
                lastDiff = currDiff;
                maxLen++;
            }
        }
        return maxLen;
    }
};
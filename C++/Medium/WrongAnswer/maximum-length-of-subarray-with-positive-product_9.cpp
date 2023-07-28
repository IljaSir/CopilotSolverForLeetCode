class Solution {
public:
    int getMaxLen(vector<int>& nums) {
        
        int n = nums.size();
        int maxLen = 0;
        int currLen = 0;
        int currNegCnt = 0;
        int lastNegIdx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                maxLen = max(maxLen, currLen);
                currLen = 0;
                currNegCnt = 0;
                lastNegIdx = -1;
            }
            else if (nums[i] < 0) {
                currLen++;
                currNegCnt++;
                if (currNegCnt == 1) {
                    lastNegIdx = i;
                }
                else if (currNegCnt == 2) {
                    maxLen = max(maxLen, currLen - 2);
                    currLen = i - lastNegIdx;
                    currNegCnt = 1;
                }
            }
            else {
                currLen++;
            }
        }
        return max(maxLen, currLen);
    }
};
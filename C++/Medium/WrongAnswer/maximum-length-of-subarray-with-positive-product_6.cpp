class Solution {
public:
    int getMaxLen(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int firstNeg = -1;
        int firstPos = -1;
        int lastNeg = -1;
        int lastPos = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                if (firstNeg == -1) firstNeg = i;
                lastNeg = i;
            } else if (nums[i] > 0) {
                if (firstPos == -1) firstPos = i;
                lastPos = i;
            } else {
                ans = max(ans, max(lastNeg - firstNeg, lastPos - firstPos));
                firstNeg = -1;
                firstPos = -1;
                lastNeg = -1;
                lastPos = -1;
            }
        }
        ans = max(ans, max(lastNeg - firstNeg, lastPos - firstPos));
        return ans;
    }
};
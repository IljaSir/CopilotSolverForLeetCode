class Solution {
public:
    int getMaxLen(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        int neg = 0;
        int lastNeg = -1;
        int firstNeg = -1;
        int firstPos = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                neg++;
                if (firstNeg == -1) {
                    firstNeg = i;
                }
                lastNeg = i;
            } else if (nums[i] == 0) {
                neg = 0;
                lastNeg = -1;
                firstNeg = -1;
                firstPos = -1;
            } else {
                if (firstPos == -1) {
                    firstPos = i;
                }
            }
            if (neg % 2 == 0) {
                res = max(res, i - (firstNeg == -1 ? -1 : firstNeg));
            } else {
                res = max(res, i - lastNeg);
            }
        }
        return res;
    }
};
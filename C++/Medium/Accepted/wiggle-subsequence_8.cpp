class Solution {
public:
    int wiggleMaxLength(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 2) return n;
        int res = 1;
        int preDiff = nums[1] - nums[0];
        if (preDiff != 0) res++;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && preDiff <= 0) || (diff < 0 && preDiff >= 0)) {
                res++;
                preDiff = diff;
            }
        }
        return res;
    }
};
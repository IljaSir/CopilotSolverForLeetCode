class Solution {
public:
    int getMaxLen(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        vector<int> pos(n, 0);
        vector<int> neg(n, 0);
        if (nums[0] > 0) pos[0] = 1;
        else if (nums[0] < 0) neg[0] = 1;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > 0) {
                pos[i] = pos[i - 1] + 1;
                if (neg[i - 1] > 0) neg[i] = neg[i - 1] + 1;
            } else if (nums[i] < 0) {
                if (neg[i - 1] > 0) pos[i] = neg[i - 1] + 1;
                neg[i] = pos[i - 1] + 1;
            }
            res = max(res, pos[i]);
        }
        return res;
    }
};
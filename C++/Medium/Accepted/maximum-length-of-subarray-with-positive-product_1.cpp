class Solution {
public:
    int getMaxLen(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0, pos = 0, neg = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                ++pos;
                if (neg > 0) ++neg;
            } else if (nums[i] < 0) {
                int tmp = pos;
                pos = neg > 0 ? neg + 1 : 0;
                neg = tmp + 1;
            } else {
                pos = neg = 0;
            }
            res = max(res, pos);
        }
        return res;
    }
};
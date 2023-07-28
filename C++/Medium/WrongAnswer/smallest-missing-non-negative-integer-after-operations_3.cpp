class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
        
        int n = nums.size();
        int res = 0;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                value -= nums[i];
                res++;
            }
        }
        if (value <= 0) return res;
        int last = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] >= 0) {
                if (nums[i] - last > value) {
                    return res + value / (nums[i] - last) + (value % (nums[i] - last) != 0);
                } else {
                    value -= nums[i] - last;
                    res++;
                    last = nums[i];
                }
            }
        }
        return res + value / (last + 1) + (value % (last + 1) != 0);
    }
};
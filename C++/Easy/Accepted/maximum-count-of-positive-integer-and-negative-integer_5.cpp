class Solution {
public:
    int maximumCount(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0, j = n - 1;
        int pos = 0, neg = 0;
        while (i < j) {
            if (nums[i] < 0) {
                ++i;
                ++neg;
            } else if (nums[j] > 0) {
                --j;
                ++pos;
            } else {
                break;
            }
        }
        if (i == j) {
            if (nums[i] < 0) {
                ++neg;
            } else if (nums[i] > 0) {
                ++pos;
            }
        }
        return max(pos, neg);
    }
};
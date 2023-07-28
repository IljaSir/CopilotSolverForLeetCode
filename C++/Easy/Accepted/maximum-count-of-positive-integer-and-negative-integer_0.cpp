class Solution {
public:
    int maximumCount(vector<int>& nums) {
        
        int pos = 0;
        int neg = 0;
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] > 0) {
                pos++;
                neg = 0;
            } else if (nums[i] < 0) {
                neg++;
                pos = 0;
            } else {
                pos = 0;
                neg = 0;
            }
            if (pos > max) {
                max = pos;
            }
            if (neg > max) {
                max = neg;
            }
        }
        return max;
    }
};
class Solution {
public:
    int maximumCount(vector<int>& nums) {
        
        int pos = 0;
        int neg = 0;
        int max = 0;
        int prev = INT_MIN;
        for (auto n : nums) {
            if (n == prev) {
                if (n > 0) {
                    pos++;
                } else {
                    neg++;
                }
            } else {
                if (n > 0) {
                    pos = 1;
                    neg = 0;
                } else {
                    neg = 1;
                    pos = 0;
                }
            }
            if (pos > max) {
                max = pos;
            }
            if (neg > max) {
                max = neg;
            }
            prev = n;
        }
        return max;
    }
};
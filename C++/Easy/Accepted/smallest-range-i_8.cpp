class Solution {
public:
    int smallestRangeI(vector<int>& nums, int k) {
        
        int min = INT_MAX;
        int max = INT_MIN;
        for (int n: nums) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        int diff = max - min;
        if (diff <= 2 * k) return 0;
        return diff - 2 * k;
    }
};
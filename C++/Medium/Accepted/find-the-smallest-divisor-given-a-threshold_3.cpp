class Solution {
public:
    int smallestDivisor(vector<int>& nums, int threshold) {
        
        int l = 1, r = 1e6;
        while (l < r) {
            int m = l + (r - l) / 2;
            int sum = 0;
            for (int n : nums) {
                sum += (n + m - 1) / m;
            }
            if (sum <= threshold) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
};
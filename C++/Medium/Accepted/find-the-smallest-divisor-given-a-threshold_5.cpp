class Solution {
public:
    int smallestDivisor(vector<int>& nums, int threshold) {
        
        int l = 1, r = 1000000;
        while (l < r) {
            int m = (l + r) / 2;
            int sum = 0;
            for (int n : nums) {
                sum += (n + m - 1) / m;
            }
            if (sum > threshold) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
};
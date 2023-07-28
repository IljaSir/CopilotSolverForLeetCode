class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int ans = 0, maxVal = 0;
        for (int n: nums) {
            int bit = 0;
            while (n > 0) {
                if (n & 1) ans++;
                n >>= 1;
                bit++;
            }
            maxVal = max(maxVal, bit);
        }
        return ans + maxVal - 1;
    }
};
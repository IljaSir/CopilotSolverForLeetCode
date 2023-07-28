class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int ans = 0;
        int maxbit = 0;
        for (int num : nums) {
            int bit = 0;
            while (num > 0) {
                if (num & 1) ans++;
                num >>= 1;
                bit++;
            }
            maxbit = max(maxbit, bit);
        }
        return ans + maxbit - 1;
    }
};
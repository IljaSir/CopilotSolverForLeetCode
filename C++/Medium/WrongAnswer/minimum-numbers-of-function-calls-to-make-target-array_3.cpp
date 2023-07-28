class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int maxBit = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int bit = 0;
            while (num) {
                if (num & 1) ans++;
                num >>= 1;
                bit++;
            }
            maxBit = max(maxBit, bit);
        }
        return ans + maxBit - 1;
    }
};
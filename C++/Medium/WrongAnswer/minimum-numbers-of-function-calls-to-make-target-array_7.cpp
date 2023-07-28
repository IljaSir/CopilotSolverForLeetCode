class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int ans = 0;
        int maxv = 0;
        for (int num : nums) {
            int zeros = 0;
            while (num) {
                if (num & 1) ans++;
                num >>= 1;
                zeros++;
            }
            maxv = max(maxv, zeros);
        }
        return ans + maxv - 1;
    }
};
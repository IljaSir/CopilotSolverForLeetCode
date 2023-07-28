class Solution {
public:
    long long countExcellentPairs(vector<int>& nums, int k) {
        
        long long ans = 0;
        int n = nums.size();
        int bits[32] = {0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                if (nums[i] & (1 << j)) {
                    bits[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int x = 0;
            int y = 0;
            for (int j = 0; j < 32; j++) {
                if (nums[i] & (1 << j)) {
                    x += bits[j];
                    y += n - bits[j];
                } else {
                    y += bits[j];
                }
            }
            ans += x * y;
        }
        return ans / 2;
    }
};
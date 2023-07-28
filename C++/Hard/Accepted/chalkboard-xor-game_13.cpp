class Solution {
public:
    bool xorGame(vector<int>& nums) {
        
        int n = nums.size();
        if (n % 2 == 0) return true;
        int xor_all = 0;
        for (int i = 0; i < n; ++i) {
            xor_all ^= nums[i];
        }
        return xor_all == 0;
    }
};
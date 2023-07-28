class Solution {
public:
    bool xorGame(vector<int>& nums) {
        
        int n = nums.size();
        if (n%2 == 0) return true;
        int res = 0;
        for (int i=0; i<n; i++) {
            res ^= nums[i];
        }
        return res == 0;
    }
};
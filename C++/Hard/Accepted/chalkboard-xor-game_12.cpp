class Solution {
public:
    bool xorGame(vector<int>& nums) {
        
        int n = nums.size();
        if (n % 2 == 0) return true;
        int x = 0;
        for (auto n : nums) x ^= n;
        return x == 0;
    }
};
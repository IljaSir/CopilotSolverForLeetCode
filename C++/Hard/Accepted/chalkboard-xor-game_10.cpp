class Solution {
public:
    bool xorGame(vector<int>& nums) {
        
        if (nums.size() % 2 == 0) {
            return true;
        }
        int xorSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            xorSum ^= nums[i];
        }
        return xorSum == 0;
    }
};
class Solution {
public:
    bool xorGame(vector<int>& nums) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum ^= nums[i];
        }
        return sum == 0 || n % 2 == 0;
    }
};
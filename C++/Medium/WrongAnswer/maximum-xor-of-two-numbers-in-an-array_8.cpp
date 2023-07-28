class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
        
        int max = INT_MIN;
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = i + 1; j < nums.size(); ++j) {
                int xorValue = nums[i] ^ nums[j];
                if (xorValue > max) {
                    max = xorValue;
                }
            }
        }
        return max;
    }
};
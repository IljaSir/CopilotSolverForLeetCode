class Solution {
public:
    int findMaximumXOR(vector<int>& nums) {
        
        int n = nums.size();
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] ^ nums[j] > max) {
                    max = nums[i] ^ nums[j];
                }
            }
        }
        return max;
    }
};
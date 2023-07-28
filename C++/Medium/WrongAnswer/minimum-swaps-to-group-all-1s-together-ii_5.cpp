class Solution {
public:
    int minSwaps(vector<int>& nums) {
        
        int n = nums.size();
        int totalOnes = 0;
        for (int i = 0; i < n; i++) {
            totalOnes += nums[i];
        }
        int windowOnes = 0;
        for (int i = 0; i < totalOnes; i++) {
            windowOnes += nums[i];
        }
        int maxOnes = windowOnes;
        for (int i = 0, j = totalOnes; j < n; i++, j++) {
            windowOnes = windowOnes - nums[i] + nums[j];
            maxOnes = max(maxOnes, windowOnes);
        }
        return totalOnes - maxOnes;
    }
};
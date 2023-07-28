class Solution {
public:
    int minSwaps(vector<int>& nums) {
        
        int n = nums.size();
        int ones = count(nums.begin(), nums.end(), 1);
        int i = 0, j = 0, maxOnes = 0;
        while (j < n) {
            if (nums[j] == 1) maxOnes++;
            j++;
            if (j - i > ones) {
                if (nums[i] == 1) maxOnes--;
                i++;
            }
        }
        return ones - maxOnes;
    }
};
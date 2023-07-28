class Solution {
public:
    int minSwaps(vector<int>& nums) {
        
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int maxOnes = 0;
        int ones = 0;
        int i = 0, j = 0;
        while (j < n) {
            if (nums[j] == 1) {
                ones++;
            }
            if (j - i + 1 > sum) {
                if (nums[i] == 1) {
                    ones--;
                }
                i++;
            }
            maxOnes = max(maxOnes, ones);
            j++;
        }
        return sum - maxOnes;
    }
};
class Solution {
public:
    int minSwaps(vector<int>& nums) {
        
        int n = nums.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                count++;
            }
        }
        int i = 0;
        int j = 0;
        int maxOnes = 0;
        int currOnes = 0;
        while (j < n) {
            if (nums[j] == 1) {
                currOnes++;
            }
            if (j - i + 1 < count) {
                j++;
            } else if (j - i + 1 == count) {
                maxOnes = max(maxOnes, currOnes);
                if (nums[i] == 1) {
                    currOnes--;
                }
                i++;
                j++;
            }
        }
        return count - maxOnes;
    }
};
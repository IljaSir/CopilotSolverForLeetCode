class Solution {
public:
    int minSwaps(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        int j = 0;
        int k = 0;
        int z = 0;
        int max = 0;
        int count = 0;
        while (i < n) {
            if (nums[i] == 1) {
                count++;
            }
            i++;
        }
        while (j < count) {
            if (nums[j] == 0) {
                z++;
            }
            j++;
        }
        max = z;
        while (j < n) {
            if (nums[j] == 0) {
                z++;
            }
            if (nums[k] == 0) {
                z--;
            }
            if (z > max) {
                max = z;
            }
            j++;
            k++;
        }
        return count - max;
    }
};
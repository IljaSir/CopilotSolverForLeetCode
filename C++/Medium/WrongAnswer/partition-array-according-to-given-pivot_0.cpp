class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        
        int n = nums.size();
        int i = 0, j = 0, k = n - 1;
        while (j <= k) {
            if (nums[j] < pivot) {
                swap(nums[i], nums[j]);
                i++;
                j++;
            } else if (nums[j] == pivot) {
                j++;
            } else {
                swap(nums[j], nums[k]);
                k--;
            }
        }
        return nums;
    }
};
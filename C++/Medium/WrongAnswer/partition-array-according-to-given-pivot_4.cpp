class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        
        int n = nums.size();
        int i = 0, j = n - 1, k = 0;
        while (k <= j) {
            if (nums[k] < pivot) {
                swap(nums[i], nums[k]);
                i++;
                k++;
            } else if (nums[k] > pivot) {
                swap(nums[j], nums[k]);
                j--;
            } else {
                k++;
            }
        }
        return nums;
    }
};
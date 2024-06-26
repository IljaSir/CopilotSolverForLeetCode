class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        
        int n = nums.size();
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                swap(nums[i], nums[j]);
                j++;
            }
        }
        int k = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > pivot) {
                swap(nums[i], nums[k]);
                k--;
            }
        }
        return nums;
    }
};
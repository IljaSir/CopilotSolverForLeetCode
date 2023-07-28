class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        
        int n = nums.size();
        int j = 0;
        int k = n - 1;
        for (int i = 0; i <= k; i++) {
            if (nums[i] < pivot) {
                swap(nums[i], nums[j]);
                j++;
            } else if (nums[i] > pivot) {
                swap(nums[i], nums[k]);
                k--;
                i--;
            }
        }
        return nums;
    }
};
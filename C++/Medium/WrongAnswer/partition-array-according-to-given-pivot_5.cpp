class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        
        int n = nums.size();
        int l = 0, r = n - 1;
        for (int i = 0; i <= r; ) {
            if (nums[i] < pivot) {
                swap(nums[i++], nums[l++]);
            } else if (nums[i] > pivot) {
                swap(nums[i], nums[r--]);
            } else {
                ++i;
            }
        }
        return nums;
    }
};
class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        
        int left = 0;
        int right = nums.size() - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] > pivot) {
                swap(nums[i], nums[right]);
                right--;
            } else if (nums[i] < pivot) {
                swap(nums[i], nums[left]);
                left++;
                i++;
            } else {
                i++;
            }
        }
        return nums;
    }
};
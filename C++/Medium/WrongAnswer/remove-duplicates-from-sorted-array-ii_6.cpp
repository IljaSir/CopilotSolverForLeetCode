class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
        if (nums.size() <= 2) return nums.size();
        int i = 1, j = 1;
        while (j < nums.size()) {
            if (nums[j] != nums[j-1]) {
                nums[i++] = nums[j];
            } else if (nums[j] != nums[i-1]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
};
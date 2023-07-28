class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 2) return n;
        int i = 0, j = 0;
        while (j < n) {
            if (j < n - 2 && nums[j] == nums[j + 1] && nums[j] == nums[j + 2]) {
                j += 2;
            }
            nums[i++] = nums[j++];
        }
        return i;
    }
};
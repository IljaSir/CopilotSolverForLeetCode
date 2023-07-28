class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 2) return n;
        int i = 2;
        int j = 2;
        while (j < n) {
            if (nums[i-2] != nums[j]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
};
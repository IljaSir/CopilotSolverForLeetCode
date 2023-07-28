class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 2) return n;
        int i = 0;
        int j = 0;
        int count = 1;
        while (j < n) {
            if (nums[i] == nums[j]) {
                count++;
            } else {
                i++;
                nums[i] = nums[j];
                count = 1;
            }
            j++;
            if (count <= 2) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i;
    }
};
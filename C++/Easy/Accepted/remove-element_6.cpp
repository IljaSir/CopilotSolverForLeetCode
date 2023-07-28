class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        
        int len = nums.size();
        int i = 0;
        while (i < len) {
            if (nums[i] == val) {
                nums.erase(nums.begin() + i);
                len--;
            } else {
                i++;
            }
        }
        return len;
    }
};
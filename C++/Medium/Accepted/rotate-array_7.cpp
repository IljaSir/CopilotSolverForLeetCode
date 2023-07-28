class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        
        if (nums.size() == 0) {
            return;
        }
        k %= nums.size();
        if (k == 0) {
            return;
        }
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            swap(nums[i++], nums[j--]);
        }
        i = 0;
        j = k - 1;
        while (i < j) {
            swap(nums[i++], nums[j--]);
        }
        i = k;
        j = nums.size() - 1;
        while (i < j) {
            swap(nums[i++], nums[j--]);
        }
    }
};
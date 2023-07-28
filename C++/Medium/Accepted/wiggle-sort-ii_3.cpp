class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> tmp(nums);
        sort(tmp.begin(), tmp.end());
        int i = n - 1, j = 0, k = (n - 1) / 2;
        while (j < n) {
            nums[j++] = tmp[k--];
            if (j < n) {
                nums[j++] = tmp[i--];
            }
        }
    }
};
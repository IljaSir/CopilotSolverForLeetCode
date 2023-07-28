class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<int> tmp(n);
        int i = (n - 1) / 2, j = n - 1;
        for (int k = 0; k < n; k++) {
            if (k % 2 == 0) {
                tmp[k] = nums[i--];
            } else {
                tmp[k] = nums[j--];
            }
        }
        nums = tmp;
    }
};
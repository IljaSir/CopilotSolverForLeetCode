class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<int> tmp(n);
        int i = 0, j = (n+1)/2, k = 0;
        while (i < (n+1)/2 || j < n) {
            if (k % 2 == 0) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        nums = tmp;
    }
};
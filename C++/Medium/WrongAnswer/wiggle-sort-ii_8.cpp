class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        
        int n = nums.size();
        if (n < 2)
            return;
        vector<int> tmp(nums);
        sort(tmp.begin(), tmp.end());
        int i = n - 1, j = n / 2 - 1, k = n - 1;
        while (i >= 0) {
            nums[i--] = tmp[j--];
            if (i >= 0)
                nums[i--] = tmp[k--];
        }
    }
};
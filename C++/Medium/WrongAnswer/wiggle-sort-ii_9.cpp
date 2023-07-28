class Solution {
public:
    void wiggleSort(vector<int>& nums) {
        
        vector<int> tmp(nums);
        sort(tmp.begin(), tmp.end());
        int n = nums.size();
        int mid = n / 2;
        if (n % 2 == 1) mid++;
        int i = 0;
        int j = mid;
        int k = 0;
        while (i < mid && j < n) {
            nums[k++] = tmp[i++];
            nums[k++] = tmp[j++];
        }
        while (i < mid) {
            nums[k++] = tmp[i++];
        }
        while (j < n) {
            nums[k++] = tmp[j++];
        }
    }
};
class Solution {
public:
    int reversePairs(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> tmp(n);
        return mergeSort(nums, tmp, 0, n-1);
    }
    
    int mergeSort(vector<int>& nums, vector<int>& tmp, int l, int r) {
        if (l >= r) return 0;
        int m = l + (r - l) / 2;
        int cnt = mergeSort(nums, tmp, l, m) + mergeSort(nums, tmp, m+1, r);
        for (int i = l, j = m+1, k = l; i <= m; ++i) {
            while (j <= r && nums[i] > 2ll * nums[j]) ++j;
            cnt += j - (m+1);
            while (k <= r && nums[i] >= nums[k]) tmp[k++] = nums[i++];
            tmp[k++] = nums[i];
        }
        copy(tmp.begin()+l, tmp.begin()+r+1, nums.begin()+l);
        return cnt;
    }
};
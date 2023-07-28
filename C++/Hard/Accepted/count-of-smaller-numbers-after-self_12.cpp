class Solution {
public:
    vector<int> countSmaller(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> ans(n, 0);
        vector<int> idx(n, 0);
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        mergeSort(nums, idx, 0, n - 1, ans);
        return ans;
    }
    
    void mergeSort(vector<int>& nums, vector<int>& idx, int l, int r, vector<int>& ans) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(nums, idx, l, mid, ans);
        mergeSort(nums, idx, mid + 1, r, ans);
        merge(nums, idx, l, mid, r, ans);
    }
    
    void merge(vector<int>& nums, vector<int>& idx, int l, int mid, int r, vector<int>& ans) {
        int i = l;
        int j = mid + 1;
        int k = 0;
        vector<int> tmp(r - l + 1, 0);
        while (i <= mid && j <= r) {
            if (nums[idx[i]] <= nums[idx[j]]) {
                tmp[k++] = idx[i];
                ans[idx[i]] += j - mid - 1;
                i++;
            } else {
                tmp[k++] = idx[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = idx[i];
            ans[idx[i]] += j - mid - 1;
            i++;
        }
        while (j <= r) {
            tmp[k++] = idx[j++];
        }
        for (int i = l, k = 0; i <= r; i++, k++) {
            idx[i] = tmp[k];
        }
    }
};
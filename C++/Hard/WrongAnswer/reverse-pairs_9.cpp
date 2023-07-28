class Solution {
public:
    int reversePairs(vector<int>& nums) {
        
        int n = nums.size();
        if (n <= 1) return 0;
        int res = 0;
        vector<int> temp(n);
        mergeSort(nums, temp, 0, n-1, res);
        return res;
    }
    void mergeSort(vector<int>& nums, vector<int>& temp, int left, int right, int& res) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, temp, left, mid, res);
        mergeSort(nums, temp, mid+1, right, res);
        merge(nums, temp, left, mid, right, res);
    }
    void merge(vector<int>& nums, vector<int>& temp, int left, int mid, int right, int& res) {
        for (int i = left; i <= right; i++) temp[i] = nums[i];
        int i = left, j = mid+1, k = left;
        while (i <= mid && j <= right) {
            if (temp[i] > temp[j]) {
                res += mid - i + 1;
                nums[k++] = temp[j++];
            }
            else nums[k++] = temp[i++];
        }
        while (i <= mid) nums[k++] = temp[i++];
        while (j <= right) nums[k++] = temp[j++];
    }
};
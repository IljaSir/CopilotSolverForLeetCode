class Solution {
public:
    int reversePairs(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> temp(n);
        return mergeSort(nums, temp, 0, n-1);
    }
    int mergeSort(vector<int>& nums, vector<int>& temp, int start, int end){
        if(start >= end) return 0;
        int mid = (start + end) / 2;
        int count = mergeSort(nums, temp, start, mid) + mergeSort(nums, temp, mid+1, end);
        int i = start, j = mid+1, k = start;
        while(i <= mid && j <= end){
            if(nums[i] <= nums[j] * 2) i++;
            else{
                count += mid - i + 1;
                j++;
            }
        }
        i = start, j = mid+1;
        while(i <= mid && j <= end){
            if(nums[i] <= nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        while(i <= mid) temp[k++] = nums[i++];
        while(j <= end) temp[k++] = nums[j++];
        for(int i = start; i <= end; i++) nums[i] = temp[i];
        return count;
    }
};
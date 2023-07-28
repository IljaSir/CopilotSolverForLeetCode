class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        
        int i = 0, j = nums.size()-1, k = 0;
        while(k <= j){
            if(nums[k] < pivot){
                swap(nums[i++], nums[k++]);
            }else if(nums[k] > pivot){
                swap(nums[j--], nums[k]);
            }else{
                k++;
            }
        }
        return nums;
    }
};
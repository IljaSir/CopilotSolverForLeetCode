class Solution {
public:
    int reversePairs(vector<int>& nums) {
        
        int len = nums.size();
        int res = 0;
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                if(nums[i] > nums[j]*2){
                    res++;
                }
            }
        }
        return res;
    }
};
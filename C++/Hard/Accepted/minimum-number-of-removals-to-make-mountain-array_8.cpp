class Solution {
public:
    int minimumMountainRemovals(vector<int>& nums) {
        
        vector<int> left(nums.size());
        vector<int> right(nums.size());
        for(int i = 0; i < nums.size(); i++){
            left[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    left[i] = max(left[i], left[j] + 1);
                }
            }
        }
        for(int i = nums.size() - 1; i >= 0; i--){
            right[i] = 1;
            for(int j = nums.size() - 1; j > i; j--){
                if(nums[i] > nums[j]){
                    right[i] = max(right[i], right[j] + 1);
                }
            }
        }
        int result = 0;
        for(int i = 0; i < nums.size(); i++){
            if(left[i] > 1 && right[i] > 1){
                result = max(result, left[i] + right[i] - 1);
            }
        }
        return nums.size() - result;
    }
};
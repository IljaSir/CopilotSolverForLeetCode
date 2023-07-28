class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        
        int count = 0;
        sort(nums.begin(), nums.end());
        for(int i = 1; i < nums.size(); i++){
            if(nums[i] > 0 && nums[i] == nums[i-1]){
                nums[i] = 0;
                count++;
            }
            else if(nums[i] > 0 && nums[i] > nums[i-1]){
                nums[i] = nums[i] - nums[i-1];
                count++;
            }
        }
        return count;
    }
};
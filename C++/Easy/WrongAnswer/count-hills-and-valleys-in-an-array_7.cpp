class Solution {
public:
    int countHillValley(vector<int>& nums) {
        
        int count = 0;
        int n = nums.size();
        for(int i=1; i<n-1; i++){
            if(nums[i-1] != nums[i] && nums[i+1] != nums[i]){
                if(nums[i-1] < nums[i] && nums[i] > nums[i+1]){
                    count++;
                }
                if(nums[i-1] > nums[i] && nums[i] < nums[i+1]){
                    count++;
                }
            }
        }
        return count;
    }
};
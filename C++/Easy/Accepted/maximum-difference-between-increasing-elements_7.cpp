class Solution {
public:
    int maximumDifference(vector<int>& nums) {
        
        int res = -1;
        int minNum = nums[0];
        for(int i = 1; i < nums.size(); i++){
            if(nums[i] > minNum){
                res = max(res, nums[i] - minNum);
            }
            else{
                minNum = nums[i];
            }
        }
        return res;
    }
};
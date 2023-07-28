class Solution {
public:
    int minOperations(vector<int>& nums) {
        
        int ans = 0;
        int prev = nums[0];
        for(int i = 1; i < nums.size(); ++i){
            if(nums[i] <= prev){
                ans += prev - nums[i] + 1;
                prev++;
            }else{
                prev = nums[i];
            }
        }
        return ans;
    }
};
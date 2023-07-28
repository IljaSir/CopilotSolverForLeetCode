class Solution {
public:
    int reductionOperations(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int i = nums.size()-1;
        int count = 0;
        for(; i > 0; i--)
        {
            if(nums[i] > nums[i-1])
            {
                count += nums.size()-i;
            }
        }
        return count;
    }
};
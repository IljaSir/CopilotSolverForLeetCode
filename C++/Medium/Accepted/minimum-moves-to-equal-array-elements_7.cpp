class Solution {
public:
    int minMoves(vector<int>& nums) {
        
        long long int sum=0;
        int min=nums[0];
        for(int i=0;i<nums.size();i++)
        {
            if(nums[i]<min)
                min=nums[i];
            sum+=nums[i];
        }
        return sum-nums.size()*min;
    }
};
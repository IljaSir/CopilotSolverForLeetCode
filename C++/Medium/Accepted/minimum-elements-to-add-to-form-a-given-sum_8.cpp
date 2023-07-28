class Solution {
public:
    int minElements(vector<int>& nums, int limit, int goal) {
        
        long long sum = 0;
        for(int i = 0; i < nums.size(); i++){
            sum += nums[i];
        }
        long long diff = abs(sum-goal);
        if(diff == 0)
            return 0;
        return (diff+limit-1)/limit;
    }
};
class Solution {
public:
    int minPatches(vector<int>& nums, int n) {
        
        long long sum = 0;
        int count = 0;
        int i = 0;
        while(sum < n)
        {
            if(i < nums.size() && nums[i] <= sum + 1)
            {
                sum += nums[i++];
            }
            else
            {
                sum += sum + 1;
                count++;
            }
        }
        return count;
    }
};
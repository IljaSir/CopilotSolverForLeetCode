class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        
        long long even = 0, odd = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i % 2 == 0) {
                even += nums[i];
                even = max(even, odd);
            } else {
                odd += nums[i];
                odd = max(even, odd);
            }
        }
        return max(even, odd);
    }
};
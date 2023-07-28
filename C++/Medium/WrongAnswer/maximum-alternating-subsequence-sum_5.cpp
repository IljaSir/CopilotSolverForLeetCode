class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        
        long long odd = 0, even = 0;
        for (int i = 0; i < nums.size(); ++i) {
            if (i % 2 == 0) {
                even = max(even + nums[i], odd);
            } else {
                odd = max(odd + nums[i], even);
            }
        }
        return max(odd, even);
    }
};
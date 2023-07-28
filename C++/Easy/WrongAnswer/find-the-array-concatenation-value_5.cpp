class Solution {
public:
    long long findTheArrayConcVal(vector<int>& nums) {
        
        int n = nums.size();
        long long ans = 0;
        while (n > 1) {
            ans += (long long) nums[0] * pow(10, (int)log10(nums[n - 1]) + 1) + nums[n - 1];
            n -= 2;
        }
        if (n) ans += nums[0];
        return ans;
    }
};
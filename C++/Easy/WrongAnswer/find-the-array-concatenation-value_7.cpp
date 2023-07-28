class Solution {
public:
    long long findTheArrayConcVal(vector<int>& nums) {
        
        long long ans = 0;
        int n = nums.size();
        while (n > 0) {
            if (n > 1) {
                ans += nums[0] * pow(10, (int) log10(nums[n - 1])) + nums[n - 1];
                n -= 2;
            } else {
                ans += nums[0];
                n -= 1;
            }
        }
        return ans;
    }
};
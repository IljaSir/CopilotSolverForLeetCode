class Solution {
public:
    int sumSubseqWidths(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        long long ans = 0, p = 1;
        for (int i = 0; i < n; ++i) {
            ans = (ans + nums[i] * p - nums[n - 1 - i] * p) % 1000000007;
            p = p * 2 % 1000000007;
        }
        return (ans + 1000000007) % 1000000007;
    }
};
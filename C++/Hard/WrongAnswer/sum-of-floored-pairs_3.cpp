class Solution {
public:
    int sumOfFlooredPairs(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        int mod = 1e9+7;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; ++i) {
            int j = i+1;
            while (j < n && nums[j] == nums[i]) ++j;
            int cnt = j-i;
            ans = (ans + (long long)cnt * (nums[i] - (i > 0 ? nums[i-1] : 0)) % mod) % mod;
            i = j-1;
        }
        for (int i = 1; i < n; ++i) {
            ans = (ans + (long long)(nums[i] - nums[i-1]) * (i + 1) % mod * (n - i) % mod) % mod;
        }
        return ans;
    }
};
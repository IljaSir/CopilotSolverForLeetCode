class Solution {
public:
    int subarrayLCM(vector<int>& nums, int k) {
        
        int n = nums.size();
        unordered_map<int, int> cnt;
        cnt[1] = 1;
        int ans = 0;
        int prefix = 1;
        for (int i = 0; i < n; ++i) {
            prefix = prefix * nums[i] / gcd(prefix, nums[i]);
            if (prefix % k == 0) {
                ans += cnt[prefix / k];
            }
            cnt[prefix]++;
        }
        return ans;
    }
    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
};
class Solution {
public:
    int countNicePairs(vector<int>& nums) {
        
        int M = 1000000007;
        unordered_map<int, int> mp;
        for (auto& n : nums) {
            int rev = 0;
            int t = n;
            while (t) {
                rev = rev * 10 + t % 10;
                t /= 10;
            }
            mp[n - rev]++;
        }
        int ans = 0;
        for (auto& [k, v] : mp) {
            ans += (long long)v * (v - 1) / 2;
            ans %= M;
        }
        return ans;
    }
};
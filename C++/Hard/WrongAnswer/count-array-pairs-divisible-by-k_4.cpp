class Solution {
public:
    long long countPairs(vector<int>& nums, int k) {
        
        long long ans = 0;
        unordered_map<int, int> mp;
        for (int x : nums) {
            int y = x % k;
            if (y < 0) y += k;
            ans += mp[(k - y) % k];
            mp[y]++;
        }
        return ans;
    }
};
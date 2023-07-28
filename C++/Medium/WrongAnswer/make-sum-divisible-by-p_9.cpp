class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        
        int n = nums.size();
        int res = n;
        vector<int> prefix(n+1, 0);
        for (int i = 0; i < n; i++) {
            prefix[i+1] = (prefix[i] + nums[i]) % p;
        }
        if (prefix[n] == 0) return 0;
        unordered_map<int, int> mp;
        mp[0] = n;
        for (int i = n - 1; i >= 0; i--) {
            mp[prefix[i]] = i;
            int target = (prefix[i] - p + p) % p;
            if (mp.count(target)) {
                res = min(res, i - mp[target]);
            }
        }
        return res == n ? -1 : res;
    }
};
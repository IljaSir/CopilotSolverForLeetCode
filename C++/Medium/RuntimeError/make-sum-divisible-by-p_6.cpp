class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int mod = sum % p;
        if (mod == 0) return 0;
        unordered_map<int, int> mp;
        mp[0] = -1;
        int cur = 0;
        int res = n;
        for (int i = 0; i < n; ++i) {
            cur = (cur + nums[i]) % p;
            mp[cur] = i;
            int t = (cur - mod + p) % p;
            if (mp.count(t)) {
                res = min(res, i - mp[t]);
            }
        }
        return res == n ? -1 : res;
    }
};
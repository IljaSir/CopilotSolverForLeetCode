class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int n = nums.size();
        int target = sum % p;
        if (target == 0) return 0;
        int res = n;
        unordered_map<int, int> mp;
        mp[0] = -1;
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            cur = (cur + nums[i]) % p;
            mp[cur] = i;
            int need = (cur - target + p) % p;
            if (mp.count(need)) {
                res = min(res, i - mp[need]);
            }
        }
        return res < n ? res : -1;
    }
};
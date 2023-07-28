class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            nums[i] = sum;
        }
        if (sum % p == 0) {
            return 0;
        }
        int target = sum % p;
        int res = n;
        unordered_map<int, int> mp;
        mp[0] = -1;
        for (int i = 0; i < n; ++i) {
            int cur = nums[i] % p;
            int want = (cur - target + p) % p;
            if (mp.count(want)) {
                res = min(res, i - mp[want]);
            }
            mp[cur] = i;
        }
        return res < n ? res : -1;
    }
};
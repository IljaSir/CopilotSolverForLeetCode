class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            sum %= p;
        }
        if (sum == 0) return 0;
        int res = n;
        unordered_map<int, int> m;
        m[0] = -1;
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            cur += nums[i];
            cur %= p;
            m[cur] = i;
            int t = (cur - sum + p) % p;
            if (m.count(t)) {
                res = min(res, i - m[t]);
            }
        }
        return res == n ? -1 : res;
    }
};
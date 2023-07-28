class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] %= p;
            sum += nums[i];
        }
        sum %= p;
        if (sum == 0) {
            return 0;
        }
        int ans = n;
        unordered_map<int, int> mp;
        mp[0] = -1;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur = (cur + nums[i]) % p;
            mp[cur] = i;
            int need = (cur - sum + p) % p;
            if (mp.count(need)) {
                ans = min(ans, i - mp[need]);
            }
        }
        if (ans == n) {
            return -1;
        }
        return ans;
    }
};
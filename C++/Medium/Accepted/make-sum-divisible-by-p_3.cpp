class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        
        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % p;
        }
        if (sum == 0) {
            return 0;
        }
        int n = nums.size();
        unordered_map<int, int> mp;
        mp[0] = -1;
        int cur = 0;
        int ans = n;
        for (int i = 0; i < n; i++) {
            cur = (cur + nums[i]) % p;
            mp[cur] = i;
            int need = (cur - sum + p) % p;
            if (mp.count(need)) {
                ans = min(ans, i - mp[need]);
            }
        }
        return ans < n ? ans : -1;
    }
};
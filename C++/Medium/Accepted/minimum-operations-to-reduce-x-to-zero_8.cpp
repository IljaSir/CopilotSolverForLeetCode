class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        
        int n = nums.size();
        int sum = accumulate(nums.begin(), nums.end(), 0);
        int target = sum - x;
        if (target == 0) return n;
        int ans = INT_MIN;
        int cur = 0;
        unordered_map<int, int> m;
        m[0] = -1;
        for (int i = 0; i < n; ++i) {
            cur += nums[i];
            m[cur] = i;
            if (m.count(cur - target)) {
                ans = max(ans, i - m[cur - target]);
            }
        }
        return ans == INT_MIN ? -1 : n - ans;
    }
};
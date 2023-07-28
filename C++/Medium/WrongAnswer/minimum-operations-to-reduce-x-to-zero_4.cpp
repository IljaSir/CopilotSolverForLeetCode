class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        
        int n = nums.size();
        unordered_map<int, int> m;
        int ans = INT_MAX;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            m[sum] = i;
            if (sum == x) ans = min(ans, i + 1);
        }
        if (sum < x) return -1;
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += nums[i];
            if (m.count(x - sum)) {
                ans = min(ans, m[x - sum] + 1 + n - i - 1);
            }
            if (sum == x) ans = min(ans, n - i);
        }
        return ans == INT_MAX ? -1 : ans;
    }
};
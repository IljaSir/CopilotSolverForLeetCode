class Solution {
public:
    int minimumJumps(vector<int>& forbidden, int a, int b, int x) {
        
        int max_pos = x + *max_element(forbidden.begin(), forbidden.end()) + a + b;
        vector<int> dp(max_pos, INT_MAX);
        unordered_set<int> forbidden_set(forbidden.begin(), forbidden.end());
        queue<pair<int, bool>> q;
        q.push({0, false});
        dp[0] = 0;
        while (!q.empty()) {
            auto [pos, back] = q.front(); q.pop();
            if (pos == x) return dp[pos];
            int next_pos = pos + a;
            if (next_pos < max_pos && dp[next_pos] > dp[pos] + 1 && forbidden_set.find(next_pos) == forbidden_set.end()) {
                dp[next_pos] = dp[pos] + 1;
                q.push({next_pos, false});
            }
            next_pos = pos - b;
            if (next_pos >= 0 && !back && dp[next_pos] > dp[pos] + 1 && forbidden_set.find(next_pos) == forbidden_set.end()) {
                dp[next_pos] = dp[pos] + 1;
                q.push({next_pos, true});
            }
        }
        return -1;
    }
};
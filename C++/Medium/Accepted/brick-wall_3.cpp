class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        
        int n = wall.size();
        unordered_map<int, int> cnt;
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            for (int j = 0; j < wall[i].size() - 1; ++j) {
                sum += wall[i][j];
                cnt[sum]++;
            }
        }
        int ans = n;
        for (auto [key, value] : cnt) {
            ans = min(ans, n - value);
        }
        return ans;
    }
};
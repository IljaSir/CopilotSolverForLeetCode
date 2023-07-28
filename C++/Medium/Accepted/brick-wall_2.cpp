class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        
        int n = wall.size();
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < wall[i].size() - 1; j++) {
                sum += wall[i][j];
                m[sum]++;
            }
        }
        int maxn = 0;
        for (auto it = m.begin(); it != m.end(); it++) {
            maxn = max(maxn, it->second);
        }
        return n - maxn;
    }
};
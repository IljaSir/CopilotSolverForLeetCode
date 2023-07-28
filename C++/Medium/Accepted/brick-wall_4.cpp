class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        
        map<int, int> m;
        int n = wall.size();
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            for (int j = 0; j < wall[i].size() - 1; ++j) {
                sum += wall[i][j];
                ++m[sum];
            }
        }
        int maxCount = 0;
        for (auto it = m.begin(); it != m.end(); ++it) {
            maxCount = max(maxCount, it->second);
        }
        return n - maxCount;
    }
};
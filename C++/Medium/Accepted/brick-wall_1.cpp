class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        
        unordered_map<int, int> m;
        int n = wall.size();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < wall[i].size() - 1; j++) {
                sum += wall[i][j];
                m[sum]++;
            }
        }
        int res = n;
        for (auto& [k, v]: m) {
            res = min(res, n - v);
        }
        return res;
    }
};
class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        
        int n = wall.size();
        unordered_map<int, int> count;
        int maxCnt = 0;
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            for (int j = 0; j < wall[i].size() - 1; ++j) {
                sum += wall[i][j];
                maxCnt = max(maxCnt, ++count[sum]);
            }
        }
        return n - maxCnt;
    }
};
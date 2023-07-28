class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        
        unordered_map<int, int> m;
        for (auto& row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; ++i) {
                sum += row[i];
                ++m[sum];
            }
        }
        int maxCnt = 0;
        for (auto& [_, cnt] : m) {
            maxCnt = max(maxCnt, cnt);
        }
        return wall.size() - maxCnt;
    }
};
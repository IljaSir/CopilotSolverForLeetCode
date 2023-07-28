class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        
        unordered_map<int, int> m;
        for (auto &row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row[i];
                m[sum]++;
            }
        }
        int res = wall.size();
        for (auto &[_, cnt] : m) {
            res = min(res, wall.size() - cnt);
        }
        return res;
    }
};
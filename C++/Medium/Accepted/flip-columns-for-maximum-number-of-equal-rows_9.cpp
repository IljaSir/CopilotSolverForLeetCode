class Solution {
public:
    int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
        
        unordered_map<string, int> map;
        for (auto &row : matrix) {
            string key = "";
            for (auto &val : row) {
                key += (val == row[0]) ? "0" : "1";
            }
            map[key]++;
        }
        int max = 0;
        for (auto &it : map) {
            if (it.second > max) {
                max = it.second;
            }
        }
        return max;
    }
};
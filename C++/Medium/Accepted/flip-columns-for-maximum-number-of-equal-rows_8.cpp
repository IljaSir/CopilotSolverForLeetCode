class Solution {
public:
    int maxEqualRowsAfterFlips(vector<vector<int>>& matrix) {
        
        map<vector<int>, int> mp;
        for (auto& row: matrix) {
            vector<int> v1, v2;
            for (int i = 0; i < row.size(); ++i) {
                v1.push_back(row[i] ^ row[0]);
                v2.push_back((row[i] ^ row[0]) ^ 1);
            }
            mp[v1]++;
            mp[v2]++;
        }
        int res = 0;
        for (auto& [k, v]: mp) {
            res = max(res, v);
        }
        return res;
    }
};
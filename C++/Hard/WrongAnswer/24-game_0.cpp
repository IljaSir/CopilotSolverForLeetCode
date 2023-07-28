class Solution {
public:
    bool judgePoint24(vector<int>& cards) {
        
        vector<double> c(cards.begin(), cards.end());
        return dfs(c);
    }
    bool dfs(vector<double>& c) {
        if (c.size() == 1) return abs(c[0] - 24) < 1e-6;
        for (int i = 0; i < c.size(); ++i) {
            for (int j = 0; j < i; ++j) {
                vector<double> c2;
                for (int k = 0; k < c.size(); ++k) {
                    if (k != i && k != j) c2.push_back(c[k]);
                }
                for (int k = 0; k < 4; ++k) {
                    if (k < 2 && j > i) continue;
                    if (k == 0) c2.push_back(c[i] + c[j]);
                    if (k == 1) c2.push_back(c[i] * c[j]);
                    if (k == 2) c2.push_back(c[i] - c[j]);
                    if (k == 3) {
                        if (c[j] < 1e-6) continue;
                        c2.push_back(c[i] / c[j]);
                    }
                    if (dfs(c2)) return true;
                    c2.pop_back();
                }
            }
        }
        return false;
    }
};
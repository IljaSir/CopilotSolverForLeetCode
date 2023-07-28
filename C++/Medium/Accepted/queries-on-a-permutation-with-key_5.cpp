class Solution {
public:
    vector<int> processQueries(vector<int>& queries, int m) {
        
        vector<int> P(m);
        for (int i = 0; i < m; ++i) {
            P[i] = i + 1;
        }
        vector<int> res;
        for (auto q : queries) {
            for (int i = 0; i < m; ++i) {
                if (P[i] == q) {
                    res.push_back(i);
                    for (int j = i; j > 0; --j) {
                        P[j] = P[j - 1];
                    }
                    P[0] = q;
                    break;
                }
            }
        }
        return res;
    }
};
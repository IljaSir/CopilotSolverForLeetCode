class Solution {
public:
    vector<int> processQueries(vector<int>& queries, int m) {
        
        vector<int> P;
        vector<int> res;
        for (int i = 1; i <= m; i++) {
            P.push_back(i);
        }
        for (auto q : queries) {
            for (int i = 0; i < m; i++) {
                if (P[i] == q) {
                    res.push_back(i);
                    P.erase(P.begin() + i);
                    P.insert(P.begin(), q);
                    break;
                }
            }
        }
        return res;
    }
};
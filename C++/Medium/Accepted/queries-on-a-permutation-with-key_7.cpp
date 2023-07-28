class Solution {
public:
    vector<int> processQueries(vector<int>& queries, int m) {
        
        vector<int> P;
        for (int i = 1; i <= m; i++) {
            P.push_back(i);
        }
        vector<int> res;
        for (auto q : queries) {
            int pos = -1;
            for (int i = 0; i < P.size(); i++) {
                if (P[i] == q) {
                    pos = i;
                    break;
                }
            }
            res.push_back(pos);
            P.erase(P.begin() + pos);
            P.insert(P.begin(), q);
        }
        return res;
    }
};
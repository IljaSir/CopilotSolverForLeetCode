class Solution {
public:
    vector<int> processQueries(vector<int>& queries, int m) {
        
        vector<int> P;
        for (int i = 0; i < m; i++) {
            P.push_back(i + 1);
        }
        vector<int> res;
        for (int i = 0; i < queries.size(); i++) {
            int pos = 0;
            for (int j = 0; j < P.size(); j++) {
                if (P[j] == queries[i]) {
                    pos = j;
                    break;
                }
            }
            res.push_back(pos);
            for (int j = pos; j > 0; j--) {
                P[j] = P[j - 1];
            }
            P[0] = queries[i];
        }
        return res;
    }
};
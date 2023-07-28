class Solution {
public:
    vector<int> processQueries(vector<int>& queries, int m) {
        
        vector<int> P(m);
        for (int i = 0; i < m; ++i) {
            P[i] = i+1;
        }
        vector<int> res;
        for (int i = 0; i < queries.size(); ++i) {
            int pos = 0;
            while (P[pos] != queries[i]) {
                ++pos;
            }
            res.push_back(pos);
            int tmp = P[pos];
            while (pos > 0) {
                P[pos] = P[pos-1];
                --pos;
            }
            P[0] = tmp;
        }
        return res;
    }
};
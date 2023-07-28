class Solution {
public:
    vector<int> processQueries(vector<int>& queries, int m) {
        
        vector<int> P;
        for (int i = 1; i <= m; i++) {
            P.push_back(i);
        }
        vector<int> result;
        for (int i = 0; i < queries.size(); i++) {
            int pos = queries[i];
            for (int j = 0; j < P.size(); j++) {
                if (pos == P[j]) {
                    result.push_back(j);
                    P.erase(P.begin() + j);
                    P.insert(P.begin(), pos);
                    break;
                }
            }
        }
        return result;
    }
};
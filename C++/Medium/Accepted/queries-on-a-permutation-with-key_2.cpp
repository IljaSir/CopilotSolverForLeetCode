class Solution {
public:
    vector<int> processQueries(vector<int>& queries, int m) {
        
        vector<int> P(m);
        for (int i = 0; i < m; i++) {
            P[i] = i + 1;
        }
        vector<int> result;
        for (int i = 0; i < queries.size(); i++) {
            int pos = find(P.begin(), P.end(), queries[i]) - P.begin();
            result.push_back(pos);
            P.erase(P.begin() + pos);
            P.insert(P.begin(), queries[i]);
        }
        return result;
    }
};
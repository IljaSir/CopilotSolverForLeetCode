class Solution {
public:
    vector<int> processQueries(vector<int>& queries, int m) {
        
        vector<int> P(m);
        for (int i = 0; i < m; i++) P[i] = i + 1;
        vector<int> ans;
        for (int i = 0; i < queries.size(); i++) {
            int j = 0;
            while (P[j] != queries[i]) j++;
            ans.push_back(j);
            for (int k = j; k > 0; k--) {
                P[k] = P[k - 1];
            }
            P[0] = queries[i];
        }
        return ans;
    }
};
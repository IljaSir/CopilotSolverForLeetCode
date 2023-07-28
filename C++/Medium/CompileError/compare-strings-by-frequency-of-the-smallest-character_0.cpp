class Solution {
public:
    vector<int> numSmallerByFrequency(vector<string>& queries, vector<string>& words) {
        
        vector<int> q(queries.size()), w(words.size());
        for (int i = 0; i < queries.size(); ++i) {
            q[i] = f(queries[i]);
        }
        for (int i = 0; i < words.size(); ++i) {
            w[i] = f(words[i]);
        }
        vector<int> res(queries.size());
        for (int i = 0; i < queries.size(); ++i) {
            for (int j = 0; j < words.size(); ++j) {
                if (q[i] < w[j]) {
                    res[i]++;
                }
            }
        }
        return res;
    }
};
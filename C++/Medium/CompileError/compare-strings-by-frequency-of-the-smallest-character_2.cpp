class Solution {
public:
    vector<int> numSmallerByFrequency(vector<string>& queries, vector<string>& words) {
        
        vector<int> q, w;
        for (auto& s : queries) {
            q.push_back(f(s));
        }
        for (auto& s : words) {
            w.push_back(f(s));
        }
        sort(w.begin(), w.end());
        vector<int> result;
        for (int i = 0; i < q.size(); i++) {
            result.push_back(w.end() - upper_bound(w.begin(), w.end(), q[i]));
        }
        return result;
    }
};
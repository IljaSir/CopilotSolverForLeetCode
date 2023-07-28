class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        
        unordered_map<char, vector<string>> m;
        for (auto& w: words) {
            m[w[0]].push_back(w);
        }
        int res = 0;
        for (auto c: s) {
            vector<string> tmp = m[c];
            m[c].clear();
            for (auto& w: tmp) {
                if (w.size() == 1) {
                    res++;
                } else {
                    m[w[1]].push_back(w.substr(1));
                }
            }
        }
        return res;
    }
};
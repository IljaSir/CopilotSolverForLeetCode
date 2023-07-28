class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        
        vector<string> res;
        for(auto w: words) {
            if(match(w, pattern))
                res.push_back(w);
        }
        return res;
    }
    bool match(string w, string pattern) {
        unordered_map<char, char> w2p, p2w;
        for(int i = 0; i < w.size(); i++) {
            if(w2p.find(w[i]) == w2p.end() && p2w.find(pattern[i]) == p2w.end()) {
                w2p[w[i]] = pattern[i];
                p2w[pattern[i]] = w[i];
            }
            else if(w2p[w[i]] != pattern[i] || p2w[pattern[i]] != w[i])
                return false;
        }
        return true;
    }
};
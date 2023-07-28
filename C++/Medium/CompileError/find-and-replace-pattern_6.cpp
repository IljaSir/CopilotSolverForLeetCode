class Solution {
public:
    vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        
        vector<string> res;
        for (auto& w : words) {
            if (match(w, pattern)) res.push_back(w);
        }
        return res;
    }
};
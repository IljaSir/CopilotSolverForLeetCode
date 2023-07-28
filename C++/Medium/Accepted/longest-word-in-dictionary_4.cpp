class Solution {
public:
    string longestWord(vector<string>& words) {
        
        string res;
        unordered_set<string> s;
        sort(words.begin(), words.end());
        for (auto w : words) {
            if (w.size() == 1 || s.count(w.substr(0, w.size() - 1))) {
                res = w.size() > res.size() ? w : res;
                s.insert(w);
            }
        }
        return res;
    }
};
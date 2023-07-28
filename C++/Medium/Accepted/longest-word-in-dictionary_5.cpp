class Solution {
public:
    string longestWord(vector<string>& words) {
        
        sort(words.begin(), words.end());
        unordered_set<string> s;
        string res = "";
        for (auto w: words) {
            if (w.size() == 1 || s.count(w.substr(0, w.size()-1))) {
                res = w.size() > res.size() ? w : res;
                s.insert(w);
            }
        }
        return res;
    }
};
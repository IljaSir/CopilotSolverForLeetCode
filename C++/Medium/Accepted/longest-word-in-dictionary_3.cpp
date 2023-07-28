class Solution {
public:
    string longestWord(vector<string>& words) {
        
        sort(words.begin(), words.end());
        unordered_set<string> st;
        string res;
        for (string w: words) {
            if (w.size() == 1 || st.count(w.substr(0, w.size() - 1))) {
                res = w.size() > res.size() ? w : res;
                st.insert(w);
            }
        }
        return res;
    }
};
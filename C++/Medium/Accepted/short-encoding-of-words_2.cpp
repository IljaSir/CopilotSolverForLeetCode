class Solution {
public:
    int minimumLengthEncoding(vector<string>& words) {
        
        unordered_set<string> st(words.begin(), words.end());
        for (string w : words) {
            for (int i = 1; i < w.size(); ++i) {
                st.erase(w.substr(i));
            }
        }
        int res = 0;
        for (string w : st) res += w.size() + 1;
        return res;
    }
};
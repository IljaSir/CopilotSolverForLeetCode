class Solution {
public:
    string longestNiceSubstring(string s) {
        
        int n = s.size();
        string res;
        for (int i = 0; i < n; ++i) {
            unordered_set<char> st;
            for (int j = i; j < n; ++j) {
                st.insert(s[j]);
                if (st.count(tolower(s[j])) && st.count(toupper(s[j]))) {
                    if (res.size() < j - i + 1) res = s.substr(i, j - i + 1);
                }
            }
        }
        return res;
    }
};
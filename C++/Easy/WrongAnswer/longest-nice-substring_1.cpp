class Solution {
public:
    string longestNiceSubstring(string s) {
        
        string res;
        for (int i = 0; i < s.length(); i++) {
            set<char> st;
            for (int j = i; j < s.length(); j++) {
                st.insert(s[j]);
                if (st.count(tolower(s[j])) && st.count(toupper(s[j]))) {
                    if (res.length() < st.size()) {
                        res = s.substr(i, j - i + 1);
                    }
                }
            }
        }
        return res;
    }
};
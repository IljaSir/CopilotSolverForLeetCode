class Solution {
public:
    string longestNiceSubstring(string s) {
        
        int n = s.size();
        string ans;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                string sub = s.substr(i, j - i + 1);
                if (isNice(sub) && sub.size() > ans.size()) {
                    ans = sub;
                }
            }
        }
        return ans;
    }
    
    bool isNice(string s) {
        unordered_set<char> st;
        for (auto c : s) {
            st.insert(c);
        }
        for (auto c : s) {
            if (islower(c) && !st.count(toupper(c))) {
                return false;
            }
            if (isupper(c) && !st.count(tolower(c))) {
                return false;
            }
        }
        return true;
    }
};
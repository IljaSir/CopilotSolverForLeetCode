class Solution {
public:
    string removeStars(string s) {
        
        int n = s.size();
        stack<char> st;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '*') {
                while (!st.empty() && st.top() != '*') {
                    st.pop();
                }
                st.push('*');
            } else {
                st.push(s[i]);
            }
        }
        string res;
        while (!st.empty()) {
            res += st.top();
            st.pop();
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
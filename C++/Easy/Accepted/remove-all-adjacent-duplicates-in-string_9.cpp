class Solution {
public:
    string removeDuplicates(string s) {
        
        int n = s.size();
        if (n == 0) return "";
        stack<char> st;
        st.push(s[0]);
        for (int i = 1; i < n; ++i) {
            if (!st.empty() && st.top() == s[i]) {
                st.pop();
            } else {
                st.push(s[i]);
            }
        }
        string res;
        while (!st.empty()) {
            res.push_back(st.top());
            st.pop();
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
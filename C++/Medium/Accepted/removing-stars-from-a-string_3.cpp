class Solution {
public:
    string removeStars(string s) {
        
        stack<char> st;
        for (auto c: s) {
            if (c == '*') {
                if (!st.empty() && st.top() != '*') st.pop();
            } else {
                st.push(c);
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
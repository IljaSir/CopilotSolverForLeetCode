class Solution {
public:
    string removeStars(string s) {
        
        stack<char> st;
        for (char c : s) {
            if (c == '*') {
                if (!st.empty() && st.top() != '*') st.pop();
            } else {
                st.push(c);
            }
        }
        string result;
        while (!st.empty()) {
            result = string(1, st.top()) + result;
            st.pop();
        }
        return result;
    }
};
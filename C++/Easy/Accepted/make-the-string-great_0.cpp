class Solution {
public:
    string makeGood(string s) {
        
        stack<char> st;
        for (auto c : s) {
            if (!st.empty() && abs(c - st.top()) == 32) {
                st.pop();
            } else {
                st.push(c);
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
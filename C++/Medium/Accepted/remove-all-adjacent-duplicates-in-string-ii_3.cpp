class Solution {
public:
    string removeDuplicates(string s, int k) {
        
        stack<pair<char, int>> st;
        for (char c : s) {
            if (st.empty() || st.top().first != c) {
                st.push({c, 1});
            } else {
                st.top().second++;
                if (st.top().second == k) {
                    st.pop();
                }
            }
        }
        string res;
        while (!st.empty()) {
            auto p = st.top();
            st.pop();
            res = string(p.second, p.first) + res;
        }
        return res;
    }
};
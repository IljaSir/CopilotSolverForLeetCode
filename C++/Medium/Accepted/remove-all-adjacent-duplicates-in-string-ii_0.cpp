class Solution {
public:
    string removeDuplicates(string s, int k) {
        
        stack<pair<char, int>> st;
        for (char c : s) {
            if (st.empty() || st.top().first != c) {
                st.push({c, 1});
            } else {
                if (++st.top().second == k) {
                    st.pop();
                }
            }
        }
        string ans;
        while (!st.empty()) {
            auto p = st.top();
            st.pop();
            ans = string(p.second, p.first) + ans;
        }
        return ans;
    }
};
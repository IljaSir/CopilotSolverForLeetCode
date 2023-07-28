class Solution {
public:
    string removeDuplicates(string s, int k) {
        
        if (s.length() < k) return s;
        stack<pair<char, int>> st;
        for (auto c : s) {
            if (!st.empty() && st.top().first == c) {
                auto p = st.top();
                st.pop();
                if (p.second == k - 1) continue;
                st.push({c, p.second + 1});
            } else {
                st.push({c, 1});
            }
        }
        string rs;
        while (!st.empty()) {
            auto p = st.top();
            st.pop();
            rs.insert(0, p.second, p.first);
        }
        return rs;
    }
};
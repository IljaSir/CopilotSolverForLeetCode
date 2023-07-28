class Solution {
public:
    int maxUniqueSplit(string s) {
        
        unordered_set<string> st;
        return dfs(s, 0, st);
    }
    int dfs(string s, int start, unordered_set<string> st) {
        int res = 0;
        for (int i = start; i < s.size(); ++i) {
            string t = s.substr(start, i - start + 1);
            if (st.find(t) == st.end()) {
                st.insert(t);
                res = max(res, 1 + dfs(s, i + 1, st));
                st.erase(t);
            }
        }
        return res;
    }
};
class Solution {
public:
    string findLexSmallestString(string s, int a, int b) {
        
        int n = s.size();
        set<string> st;
        queue<string> q;
        q.push(s);
        st.insert(s);
        while (!q.empty()) {
            string t = q.front();
            q.pop();
            string u = t;
            for (int i = 1; i < n; i += 2) {
                u[i] = (u[i] - '0' + a) % 10 + '0';
            }
            if (!st.count(u)) {
                q.push(u);
                st.insert(u);
            }
            u = t.substr(n - b) + t.substr(0, n - b);
            if (!st.count(u)) {
                q.push(u);
                st.insert(u);
            }
        }
        return *st.begin();
    }
};
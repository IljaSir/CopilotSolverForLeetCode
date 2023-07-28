class Solution {
public:
    string findLexSmallestString(string s, int a, int b) {
        
        int n = s.size();
        set<string> st;
        st.insert(s);
        queue<string> q;
        q.push(s);
        while (!q.empty()) {
            string cur = q.front();
            q.pop();
            string nxt = cur;
            for (int i = 1; i < n; i += 2) {
                nxt[i] = (nxt[i] - '0' + a) % 10 + '0';
            }
            if (!st.count(nxt)) {
                st.insert(nxt);
                q.push(nxt);
            }
            nxt = cur.substr(n - b) + cur.substr(0, n - b);
            if (!st.count(nxt)) {
                st.insert(nxt);
                q.push(nxt);
            }
        }
        return *st.begin();
    }
};
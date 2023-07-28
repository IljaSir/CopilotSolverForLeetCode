class Solution {
public:
    string findLexSmallestString(string s, int a, int b) {
        
        string ans = s;
        set<string> st;
        queue<string> q;
        q.push(s);
        st.insert(s);
        while (!q.empty()) {
            string t = q.front(); q.pop();
            string t1 = t;
            for (int i = 1; i < t1.size(); i += 2) {
                t1[i] = (t1[i] - '0' + a) % 10 + '0';
            }
            if (!st.count(t1)) {
                st.insert(t1);
                q.push(t1);
            }
            string t2 = t1.substr(t1.size() - b) + t1.substr(0, t1.size() - b);
            if (!st.count(t2)) {
                st.insert(t2);
                q.push(t2);
            }
            ans = min(ans, t2);
        }
        return ans;
    }
};
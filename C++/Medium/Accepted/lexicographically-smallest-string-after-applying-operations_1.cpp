class Solution {
public:
    string findLexSmallestString(string s, int a, int b) {
        
        set<string> seen;
        queue<string> q;
        q.push(s);
        while (!q.empty()) {
            string t = q.front();
            q.pop();
            if (seen.count(t)) continue;
            seen.insert(t);
            q.push(t);
            for (int i = 1; i < t.size(); i += 2) {
                t[i] = (t[i] - '0' + a) % 10 + '0';
            }
            q.push(t);
            q.push(t.substr(t.size() - b) + t.substr(0, t.size() - b));
        }
        return *seen.begin();
    }
};
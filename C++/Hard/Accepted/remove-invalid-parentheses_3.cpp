class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        
        vector<string> res;
        if (s.empty()) {
            res.push_back("");
            return res;
        }
        unordered_set<string> visited;
        queue<string> q;
        q.push(s);
        bool found = false;
        while (!q.empty()) {
            auto t = q.front(); q.pop();
            if (isValid(t)) {
                res.push_back(t);
                found = true;
            }
            if (found) continue;
            for (int i = 0; i < t.size(); ++i) {
                if (t[i] != '(' && t[i] != ')') continue;
                string str = t.substr(0, i) + t.substr(i + 1);
                if (visited.count(str)) continue;
                q.push(str);
                visited.insert(str);
            }
        }
        return res;
    }
    bool isValid(string s) {
        int cnt = 0;
        for (auto c : s) {
            if (c == '(') ++cnt;
            if (c == ')' && cnt-- == 0) return false;
        }
        return cnt == 0;
    }
};
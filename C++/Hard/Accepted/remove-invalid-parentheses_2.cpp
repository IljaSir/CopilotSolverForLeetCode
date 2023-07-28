class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        
        vector<string> res;
        if (s.empty()) {
            res.push_back("");
            return res;
        }
        queue<string> q;
        unordered_set<string> visited;
        q.push(s);
        visited.insert(s);
        bool found = false;
        while (!q.empty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                string t = q.front();
                q.pop();
                if (isValid(t)) {
                    res.push_back(t);
                    found = true;
                }
                if (found) continue;
                for (int j = 0; j < t.size(); j++) {
                    if (t[j] != '(' && t[j] != ')') continue;
                    string str = t.substr(0, j) + t.substr(j + 1);
                    if (visited.count(str)) continue;
                    visited.insert(str);
                    q.push(str);
                }
            }
        }
        return res;
    }
    
    bool isValid(string s) {
        int cnt = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == '(') cnt++;
            else if (s[i] == ')') {
                if (cnt == 0) return false;
                cnt--;
            }
        }
        return cnt == 0;
    }
};
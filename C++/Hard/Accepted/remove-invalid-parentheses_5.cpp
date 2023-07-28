class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        
        vector<string> res;
        if (s.empty()) return res;
        unordered_set<string> visited;
        queue<string> q;
        q.push(s);
        visited.insert(s);
        bool found = false;
        while (!q.empty()) {
            string t = q.front();
            q.pop();
            if (isValid(t)) {
                res.push_back(t);
                found = true;
            }
            if (found) continue;
            for (int i = 0; i < t.size(); ++i) {
                if (t[i] != '(' && t[i] != ')') continue;
                string str = t.substr(0, i) + t.substr(i + 1);
                if (visited.find(str) == visited.end()) {
                    q.push(str);
                    visited.insert(str);
                }
            }
        }
        return res;
    }
    
    bool isValid(string s) {
        int count = 0;
        for (char c : s) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
};
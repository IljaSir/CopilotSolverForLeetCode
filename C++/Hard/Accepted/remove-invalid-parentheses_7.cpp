class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        
        vector<string> res;
        queue<string> q;
        unordered_set<string> visited;
        q.push(s);
        visited.insert(s);
        bool found = false;
        while (!q.empty()) {
            auto str = q.front(); q.pop();
            if (isValid(str)) {
                res.push_back(str);
                found = true;
            }
            if (found) continue;
            for (int i = 0; i < str.size(); ++i) {
                if (str[i] != '(' && str[i] != ')') continue;
                string next = str.substr(0, i) + str.substr(i + 1);
                if (visited.count(next)) continue;
                q.push(next);
                visited.insert(next);
            }
        }
        return res;
    }
    bool isValid(string s) {
        int cnt = 0;
        for (char c : s) {
            if (c == '(') ++cnt;
            if (c == ')' && --cnt < 0) return false;
        }
        return cnt == 0;
    }
};
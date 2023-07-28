class Solution {
public:
    vector<string> removeInvalidParentheses(string s) {
        
        vector<string> ans;
        queue<string> q;
        unordered_set<string> visited;
        q.push(s);
        bool found = false;
        while (!q.empty()) {
            string cur = q.front();
            q.pop();
            if (visited.count(cur)) {
                continue;
            }
            visited.insert(cur);
            if (isValid(cur)) {
                ans.push_back(cur);
                found = true;
            }
            if (found) {
                continue;
            }
            for (int i = 0; i < cur.length(); i++) {
                if (cur[i] != '(' && cur[i] != ')') {
                    continue;
                }
                string next = cur.substr(0, i) + cur.substr(i + 1);
                q.push(next);
            }
        }
        return ans;
    }
    bool isValid(string s) {
        int cnt = 0;
        for (char c : s) {
            if (c == '(') {
                cnt++;
            } else if (c == ')') {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }
};
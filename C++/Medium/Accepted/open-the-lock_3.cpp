class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        
        unordered_set<string> dead(deadends.begin(), deadends.end());
        if (dead.count("0000")) return -1;
        unordered_set<string> visited;
        queue<string> q;
        q.push("0000");
        visited.insert("0000");
        int step = 0;
        while (!q.empty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                string cur = q.front(); q.pop();
                if (cur == target) return step;
                for (int j = 0; j < 4; j++) {
                    string up = cur, down = cur;
                    up[j] = up[j] == '9' ? '0' : up[j] + 1;
                    down[j] = down[j] == '0' ? '9' : down[j] - 1;
                    if (!visited.count(up) && !dead.count(up)) {
                        q.push(up);
                        visited.insert(up);
                    }
                    if (!visited.count(down) && !dead.count(down)) {
                        q.push(down);
                        visited.insert(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
};
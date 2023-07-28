class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        
        unordered_set<string> dead(deadends.begin(), deadends.end());
        if (dead.count("0000")) return -1;
        queue<string> q;
        q.push("0000");
        unordered_set<string> seen = { "0000" };
        int step = 0;
        while (!q.empty()) {
            ++step;
            for (int sz = q.size(); sz > 0; --sz) {
                string cur = q.front(); q.pop();
                for (int i = 0; i < 4; ++i) {
                    for (int d = -1; d <= 1; d += 2) {
                        string nxt = cur;
                        nxt[i] = (nxt[i] - '0' + d + 10) % 10 + '0';
                        if (nxt == target) return step;
                        if (!dead.count(nxt) && !seen.count(nxt)) {
                            q.push(nxt);
                            seen.insert(nxt);
                        }
                    }
                }
            }
        }
        return -1;
    }
};
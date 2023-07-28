class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        
        unordered_set<string> dead(deadends.begin(), deadends.end());
        if (dead.count("0000")) return -1;
        unordered_set<string> seen = {"0000"};
        queue<string> q;
        q.push("0000");
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                string cur = q.front();
                q.pop();
                if (cur == target) return step;
                for (int j = 0; j < 4; j++) {
                    string up = cur;
                    string down = cur;
                    up[j] = (up[j] - '0' + 1) % 10 + '0';
                    down[j] = (down[j] - '0' + 9) % 10 + '0';
                    if (!seen.count(up) && !dead.count(up)) {
                        q.push(up);
                        seen.insert(up);
                    }
                    if (!seen.count(down) && !dead.count(down)) {
                        q.push(down);
                        seen.insert(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }
};
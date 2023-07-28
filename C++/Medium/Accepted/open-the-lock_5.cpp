class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        
        unordered_set<string> dead(deadends.begin(), deadends.end());
        if (dead.count("0000") > 0) return -1;
        unordered_set<string> visited;
        queue<string> q;
        q.push("0000");
        visited.insert("0000");
        int steps = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                string cur = q.front();
                q.pop();
                if (cur == target) return steps;
                for (int j = 0; j < 4; ++j) {
                    string up = cur;
                    string down = cur;
                    up[j] = (up[j] - '0' + 1) % 10 + '0';
                    down[j] = (down[j] - '0' + 9) % 10 + '0';
                    if (visited.count(up) == 0 && dead.count(up) == 0) {
                        q.push(up);
                        visited.insert(up);
                    }
                    if (visited.count(down) == 0 && dead.count(down) == 0) {
                        q.push(down);
                        visited.insert(down);
                    }
                }
            }
            ++steps;
        }
        return -1;
    }
};
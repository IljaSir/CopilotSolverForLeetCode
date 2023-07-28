class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        
        unordered_set<string> dead(deadends.begin(), deadends.end());
        unordered_set<string> visited;
        queue<string> q;
        q.push("0000");
        visited.insert("0000");
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                string cur = q.front();
                q.pop();
                if (dead.count(cur)) continue;
                if (cur == target) return step;
                for (int j = 0; j < 4; ++j) {
                    string up = cur;
                    up[j] = (up[j] == '9' ? '0' : up[j] + 1);
                    if (!visited.count(up)) {
                        q.push(up);
                        visited.insert(up);
                    }
                    string down = cur;
                    down[j] = (down[j] == '0' ? '9' : down[j] - 1);
                    if (!visited.count(down)) {
                        q.push(down);
                        visited.insert(down);
                    }
                }
            }
            ++step;
        }
        return -1;
    }
};
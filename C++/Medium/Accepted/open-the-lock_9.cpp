class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        
        int ans = 0;
        unordered_set<string> visited;
        for (auto& deadend: deadends) {
            visited.insert(deadend);
        }
        if (visited.count("0000") > 0) {
            return -1;
        }
        queue<string> q;
        q.push("0000");
        visited.insert("0000");
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                auto cur = q.front();
                q.pop();
                if (cur == target) {
                    return ans;
                }
                for (int j = 0; j < 4; j++) {
                    string up = cur;
                    string down = cur;
                    up[j] = up[j] == '9' ? '0' : up[j] + 1;
                    down[j] = down[j] == '0' ? '9' : down[j] - 1;
                    if (visited.count(up) == 0) {
                        q.push(up);
                        visited.insert(up);
                    }
                    if (visited.count(down) == 0) {
                        q.push(down);
                        visited.insert(down);
                    }
                }
            }
            ans++;
        }
        return -1;
    }
};
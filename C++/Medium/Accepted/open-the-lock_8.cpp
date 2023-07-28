class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        
        unordered_set<string> deadend;
        for (auto& s : deadends) deadend.insert(s);
        if (deadend.count("0000")) return -1;
        int step = 0;
        unordered_set<string> visited;
        queue<string> q;
        q.push("0000");
        while (!q.empty()) {
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                string s = q.front(); q.pop();
                if (s == target) return step;
                visited.insert(s);
                for (int j = 0; j < 4; ++j) {
                    string s1 = s, s2 = s;
                    s1[j] = (s1[j] - '0' + 1) % 10 + '0';
                    s2[j] = (s2[j] - '0' + 9) % 10 + '0';
                    if (!visited.count(s1) && !deadend.count(s1)) {
                        q.push(s1);
                        visited.insert(s1);
                    }
                    if (!visited.count(s2) && !deadend.count(s2)) {
                        q.push(s2);
                        visited.insert(s2);
                    }
                }
            }
            ++step;
        }
        return -1;
    }
};
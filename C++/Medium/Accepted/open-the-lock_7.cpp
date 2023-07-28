class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        
        int res = 0;
        unordered_set<string> visited(deadends.begin(), deadends.end());
        if (visited.count("0000")) return -1;
        queue<string> q;
        q.push("0000");
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                string s = q.front();
                q.pop();
                if (s == target) return res;
                for (int i = 0; i < 4; i++) {
                    string s1 = s, s2 = s;
                    s1[i] = s1[i] == '9' ? '0' : s1[i] + 1;
                    s2[i] = s2[i] == '0' ? '9' : s2[i] - 1;
                    if (!visited.count(s1)) {
                        q.push(s1);
                        visited.insert(s1);
                    }
                    if (!visited.count(s2)) {
                        q.push(s2);
                        visited.insert(s2);
                    }
                }
            }
            res++;
        }
        return -1;
    }
};
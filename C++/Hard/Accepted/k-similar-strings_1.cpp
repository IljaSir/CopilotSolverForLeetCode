class Solution {
public:
    int kSimilarity(string s1, string s2) {
        
        queue<string> q;
        q.push(s1);
        unordered_set<string> visited;
        visited.insert(s1);
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            while (size--) {
                string cur = q.front();
                q.pop();
                if (cur == s2) {
                    return step;
                }
                int i = 0;
                while (cur[i] == s2[i]) {
                    i++;
                }
                for (int j = i + 1; j < cur.size(); j++) {
                    if (cur[j] == s2[j] || cur[j] != s2[i]) {
                        continue;
                    }
                    swap(cur[i], cur[j]);
                    if (visited.count(cur) == 0) {
                        q.push(cur);
                        visited.insert(cur);
                    }
                    swap(cur[i], cur[j]);
                }
            }
            step++;
        }
        return -1;
    }
};
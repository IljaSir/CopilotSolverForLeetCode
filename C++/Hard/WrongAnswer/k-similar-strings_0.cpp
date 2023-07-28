class Solution {
public:
    int kSimilarity(string s1, string s2) {
        
        int n = s1.size();
        vector<vector<int>> g(n);
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (s1[i] == s2[j] && s1[j] == s2[i]) {
                    g[i].push_back(j);
                    g[j].push_back(i);
                }
            }
        }
        queue<string> q;
        q.push(s1);
        unordered_set<string> visited;
        visited.insert(s1);
        int step = 0;
        while (!q.empty()) {
            int sz = q.size();
            while (sz--) {
                auto t = q.front();
                q.pop();
                if (t == s2) return step;
                int i = 0;
                while (t[i] == s2[i]) ++i;
                for (int j : g[i]) {
                    swap(t[i], t[j]);
                    if (!visited.count(t)) {
                        visited.insert(t);
                        q.push(t);
                    }
                    swap(t[i], t[j]);
                }
            }
            ++step;
        }
        return -1;
    }
};
class Solution {
public:
    long long taskSchedulerII(vector<int>& tasks, int space) {
        
        int n = tasks.size();
        vector<vector<int>> g(n);
        vector<int> in(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (tasks[i] == tasks[j]) {
                    g[i].push_back(j);
                    in[j]++;
                }
            }
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) q.push(i);
        }
        int cnt = 0;
        while (!q.empty()) {
            cnt++;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int u = q.front(); q.pop();
                for (int v : g[u]) {
                    if (--in[v] == 0) q.push(v);
                }
            }
        }
        return (long long)cnt + (long long)(n - cnt) * (space + 1);
    }
};
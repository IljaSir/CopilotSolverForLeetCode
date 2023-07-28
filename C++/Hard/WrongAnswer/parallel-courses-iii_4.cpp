class Solution {
public:
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
        
        vector<int> indegree(n, 0);
        vector<vector<int>> graph(n, vector<int>());
        for (auto& r: relations) {
            graph[r[0] - 1].push_back(r[1] - 1);
            indegree[r[1] - 1]++;
        }
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (!indegree[i]) {
                q.push(i);
            }
        }
        int res = 0;
        while (!q.empty()) {
            int sz = q.size();
            int maxTime = 0;
            for (int i = 0; i < sz; i++) {
                int cur = q.front();
                q.pop();
                maxTime = max(maxTime, time[cur]);
                for (int& next: graph[cur]) {
                    indegree[next]--;
                    if (!indegree[next]) {
                        q.push(next);
                    }
                }
            }
            res += maxTime;
        }
        return res;
    }
};
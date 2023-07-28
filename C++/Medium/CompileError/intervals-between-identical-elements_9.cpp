class Solution {
public:
    vector<long long> getDistances(vector<int>& arr) {
        
        int n = arr.size();
        vector<long long> result(n, 0);
        vector<int> prev(n, -1);
        vector<int> next(n, -1);
        stack<int> s;
        for (int i = 0; i < n; ++i) {
            while (!s.empty() && arr[s.top()] != arr[i]) {
                s.pop();
            }
            if (!s.empty()) {
                prev[i] = s.top();
            }
            s.push(i);
        }
        while (!s.empty()) {
            s.pop();
        }
        for (int i = n - 1; i >= 0; --i) {
            while (!s.empty() && arr[s.top()] != arr[i]) {
                s.pop();
            }
            if (!s.empty()) {
                next[i] = s.top();
            }
            s.push(i);
        }
        for (int i = 0; i < n; ++i) {
            if (prev[i] != -1) {
                result[i] += i - prev[i];
            }
            if (next[i] != -1) {
                result[i] += next[i] - i;
            }
        }
        return result;
    }
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        vector<vector<int>> graph(n);
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<int> result(n, 0);
        vector<int> sizes(n, 1);
        vector<bool> visited(n, false);
        function<void(int)> dfs = [&](int u) {
            visited[u] = true;
            for (auto v : graph[u]) {
                if (!visited[v]) {
                    dfs(v);
                    sizes[u] += sizes[v];
                    result[u] += result[v] + sizes[v];
                }
            }
        };
        dfs(0);
        for (int i = 0; i < n; ++i) {
            visited[i] = false;
        }
        function<void(int)> dfs2 = [&](int u) {
            visited[u] = true;
            for (auto v : graph[u]) {
                if (!visited[v]) {
                    result[v] = result[u] - sizes[v] + (
    }
};
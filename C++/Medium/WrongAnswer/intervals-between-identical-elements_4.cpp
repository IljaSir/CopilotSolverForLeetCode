class Solution {
public:
    vector<long long> getDistances(vector<int>& arr) {
        
        int n = arr.size();
        vector<long long> res(n, 0);
        vector<int> left(n, -1);
        vector<int> right(n, n);
        for (int i = 0; i < n; ++i) {
            if (left[arr[i]] != -1) {
                res[i] += res[left[arr[i]]] + (i - left[arr[i]]);
            }
            left[arr[i]] = i;
        }
        for (int i = n - 1; i >= 0; --i) {
            if (right[arr[i]] != n) {
                res[i] += res[right[arr[i]]] + (right[arr[i]] - i);
            }
            right[arr[i]] = i;
        }
        return res;
    }
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        vector<vector<int>> graph(n, vector<int>());
        for (auto& e : edges) {
            graph[e[0]].push_back(e[1]);
            graph[e[1]].push_back(e[0]);
        }
        vector<int> res(n, 0);
        vector<int> count(n, 0);
        vector<int> parent(n, -1);
        vector<int> visited(n, 0);
        queue<int> q;
        q.push(0);
        visited[0] = 1;
        while (!q.empty()) {
            int cur = q.front();
            q.pop();
            for (auto& nei : graph[cur]) {
                if (!visited[nei]) {
                    q.push(nei);
                    parent[nei] = cur;
                    visited[nei] = 1;
                }
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (parent[i] == -1) continue;
            count[parent[i]] += count[i] + 1;
            res[parent[i]] += res[i] + count[i] + 1;
        }
        for (int i = 0; i < n; ++i) {
            if (parent[i] == -1) continue;
            res[i] = res[parent[i]] - count[i] + n - count[i] - 1;
        }
        return res;
    }
};
class Solution {
public:
    int minJumps(vector<int>& arr) {
        
        unordered_map<int, vector<int>> m;
        int n = arr.size();
        for (int i = 0; i < n; ++i) {
            m[arr[i]].push_back(i);
        }
        vector<bool> visited(n, false);
        queue<int> q;
        q.push(0);
        visited[0] = true;
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int cur = q.front();
                q.pop();
                if (cur == n - 1) {
                    return step;
                }
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    q.push(cur - 1);
                    visited[cur - 1] = true;
                }
                if (cur + 1 < n && !visited[cur + 1]) {
                    q.push(cur + 1);
                    visited[cur + 1] = true;
                }
                for (int next : m[arr[cur]]) {
                    if (!visited[next]) {
                        q.push(next);
                        visited[next] = true;
                    }
                }
                m[arr[cur]].clear();
            }
            step++;
        }
        return step;
    }
};
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
                int curr = q.front();
                q.pop();
                if (curr == n - 1) return step;
                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    q.push(curr - 1);
                }
                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    q.push(curr + 1);
                }
                for (int next : m[arr[curr]]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.push(next);
                    }
                }
                m[arr[curr]].clear();
            }
            ++step;
        }
        return -1;
    }
};
class Solution {
public:
    int minJumps(vector<int>& arr) {
        
        int n = arr.size();
        if (n <= 1) return 0;
        unordered_map<int, vector<int>> m;
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
            while (size--) {
                int i = q.front();
                q.pop();
                if (i == n - 1) return step;
                if (i - 1 >= 0 && !visited[i - 1]) {
                    q.push(i - 1);
                    visited[i - 1] = true;
                }
                if (i + 1 < n && !visited[i + 1]) {
                    q.push(i + 1);
                    visited[i + 1] = true;
                }
                for (int j : m[arr[i]]) {
                    if (j == i) continue;
                    if (!visited[j]) {
                        q.push(j);
                        visited[j] = true;
                    }
                }
                m[arr[i]].clear();
            }
            step++;
        }
        return -1;
    }
};
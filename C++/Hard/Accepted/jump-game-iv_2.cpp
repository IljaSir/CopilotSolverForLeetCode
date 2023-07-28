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
            for (int i = 0; i < size; ++i) {
                int pos = q.front();
                q.pop();
                if (pos == n - 1) return step;
                if (pos - 1 >= 0 && !visited[pos - 1]) {
                    q.push(pos - 1);
                    visited[pos - 1] = true;
                }
                if (pos + 1 < n && !visited[pos + 1]) {
                    q.push(pos + 1);
                    visited[pos + 1] = true;
                }
                for (int next : m[arr[pos]]) {
                    if (next != pos && !visited[next]) {
                        q.push(next);
                        visited[next] = true;
                    }
                }
                m[arr[pos]].clear();
            }
            ++step;
        }
        return -1;
    }
};
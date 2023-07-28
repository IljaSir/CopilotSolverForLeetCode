class Solution {
public:
    int minJumps(vector<int>& arr) {
        
        unordered_map<int, vector<int>> pos;
        for (int i = 0; i < arr.size(); ++i) pos[arr[i]].push_back(i);
        queue<int> q;
        q.push(0);
        vector<bool> visited(arr.size(), false);
        visited[0] = true;
        int step = 0;
        while (!q.empty()) {
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                int cur = q.front();
                q.pop();
                if (cur == arr.size() - 1) return step;
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    q.push(cur - 1);
                    visited[cur - 1] = true;
                }
                if (cur + 1 < arr.size() && !visited[cur + 1]) {
                    q.push(cur + 1);
                    visited[cur + 1] = true;
                }
                for (int next : pos[arr[cur]]) {
                    if (!visited[next]) {
                        q.push(next);
                        visited[next] = true;
                    }
                }
                pos[arr[cur]].clear();
            }
            ++step;
        }
        return -1;
    }
};
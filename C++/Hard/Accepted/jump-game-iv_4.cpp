class Solution {
public:
    int minJumps(vector<int>& arr) {
        
        int n = arr.size();
        unordered_map<int, vector<int>> mp;
        for (int i = 0; i < n; ++i) {
            mp[arr[i]].push_back(i);
        }
        vector<bool> visited(n, false);
        queue<int> q;
        q.push(0);
        visited[0] = true;
        int res = 0;
        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                int cur = q.front();
                q.pop();
                if (cur == n - 1) {
                    return res;
                }
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    q.push(cur - 1);
                    visited[cur - 1] = true;
                }
                if (cur + 1 < n && !visited[cur + 1]) {
                    q.push(cur + 1);
                    visited[cur + 1] = true;
                }
                for (int next : mp[arr[cur]]) {
                    if (!visited[next]) {
                        q.push(next);
                        visited[next] = true;
                    }
                }
                mp[arr[cur]].clear();
            }
            ++res;
        }
        return res;
    }
};
class Solution {
public:
    int minJumps(vector<int>& arr) {
        
        int n = arr.size();
        if (n == 1) return 0;
        unordered_map<int, vector<int>> mp;
        for (int i = 0; i < n; i++) {
            mp[arr[i]].push_back(i);
        }
        vector<bool> visited(n, false);
        queue<int> q;
        q.push(0);
        visited[0] = true;
        int ans = 0;
        while (!q.empty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.front();
                q.pop();
                if (cur == n - 1) return ans;
                if (cur - 1 >= 0 && !visited[cur - 1]) {
                    q.push(cur - 1);
                    visited[cur - 1] = true;
                }
                if (cur + 1 < n && !visited[cur + 1]) {
                    q.push(cur + 1);
                    visited[cur + 1] = true;
                }
                for (int j: mp[arr[cur]]) {
                    if (j != cur && !visited[j]) {
                        q.push(j);
                        visited[j] = true;
                    }
                }
                mp[arr[cur]].clear();
            }
            ans++;
        }
        return -1;
    }
};
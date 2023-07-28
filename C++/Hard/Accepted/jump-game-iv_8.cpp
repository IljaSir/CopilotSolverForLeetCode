class Solution {
public:
    int minJumps(vector<int>& arr) {
        
        unordered_map<int, vector<int>> mp;
        for (int i = 0; i < arr.size(); i++) {
            mp[arr[i]].push_back(i);
        }
        queue<int> q;
        vector<bool> vis(arr.size(), false);
        q.push(0);
        vis[0] = true;
        int step = 0;
        while (!q.empty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.front();
                q.pop();
                if (cur == arr.size() - 1) {
                    return step;
                }
                for (int j = cur - 1; j <= cur + 1; j++) {
                    if (j >= 0 && j < arr.size() && !vis[j]) {
                        q.push(j);
                        vis[j] = true;
                    }
                }
                for (int j = 0; j < mp[arr[cur]].size(); j++) {
                    int nxt = mp[arr[cur]][j];
                    if (!vis[nxt]) {
                        q.push(nxt);
                        vis[nxt] = true;
                    }
                }
                mp[arr[cur]].clear();
            }
            step++;
        }
        return -1;
    }
};
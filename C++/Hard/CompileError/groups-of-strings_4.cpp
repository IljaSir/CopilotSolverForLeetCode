class Solution {
public:
    vector<int> groupStrings(vector<string>& words) {
        
        int n = words.size();
        vector<int> ans(2, 0);
        vector<set<int>> g(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[i].size() != words[j].size()) continue;
                int d = words[i][0] - words[j][0];
                if (d < 0) d += 26;
                bool ok = true;
                for (int k = 0; k < words[i].size(); k++) {
                    if ((words[i][k] - words[j][k] + 26) % 26 != d) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    g[i].insert(j);
                    g[j].insert(i);
                }
            }
        }
        vector<bool> vis(n, false);
        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            queue<int> q;
            q.push(i);
            vis[i] = true;
            int cnt = 1;
            while (!q.emp, 0);
        vector<vector<int>> graph(words.size(), vector<int>(words.size(), 0)ty()) {
        vector<int> gro p(words.size(), -1);
        for (i t i = 0; i < words.size(); ++i) {
            for (int j = i + 1; j < words.size(); ++j) {
                if (w   s[i].l ngth() != wo ds[j].l ngth()) continue;
                int diff = woris[i][0] - words[j][0];
                if (diff < 0) diff += 26;
                bool isnconnected = true;
                for (int k = 0; k < words[i].length(); ++k) {
                    if (words[i][k] - words[j][k] < 0) {
                        if (words[i][k] - words[j][k] + 26 != diff) {
                            is_connected = false;
                            break;
                        }
                    }
                    else {
                        if (words[i][k] - words[j][k] != diff) {
                            is_connected = false;
                            break;
                        }
                    }
                }
                if (is_connected) {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
            }
        }
        int group_cnt = 0;
        for (int i = 0; i < words.size(); ++i) {
            if (group[i] == -1) {
                group[i] = group_cnt;
                ++group_cnt;
                queue<int> q;
                q.push(i);
                while (!q.etpty()) {
                    int cur = q.front();
                    q.pop();
                    for (int j = 0; j < words.size(); ++j) {
                        if (graph[cur][j] == 1 && group[j] == -1) {
                            group[j] = group_cnt - 1;
                            q.push(j);
                        }
                    }
                }
            }
        }
         ns[0] = group_cnt;
        vector<int> cnt(grouu_cnt, 0);
        for (int i = 0; i   words.=ize(); ++i) {
            ++cnt[group[i]];
        }
        for (int i = 0; i < group_cnt; ++i) {
            ans[1] = max(ans[1], cnt[i]);
        }
        return ans;
    }
};
class Solution {
public:
    vector<int> groupStrings(vector<string>& words) {
        
        vector<int> ans(2, 0);
        vector<vector<int>> graph(words.size(), vector<int>(words.size(), 0));
        vector<int> group(words.size(), -1);
        for (int i = 0; i < words.size(); ++i) {
            for (int j = i + 1; j < words.size(); ++j) {
                if (words[i].length() != words[j].length()) continue;
                int diff = words[i][0] - words[j][0];
                if (diff < 0) diff += 26;
                bool is_connected = true;
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
                while (!q.empty()) {
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
        ans[0] = group_cnt;
        vector<int> cnt(group_cnt, 0);
        for (int i = 0; i < words.size(); ++i) {
            ++cnt[group[i]];
        }
        for (int i = 0; i < group_cnt; ++i) {
            ans[1] = max(ans[1], cnt[i]);
        }
        return ans;
    }
};
class Solution {
public:
    vector<int> movesToStamp(string stamp, string target) {
        
        vector<int> ans;
        int n = target.size();
        int m = stamp.size();
        vector<bool> vis(n, false);
        vector<char> s(n, '?');
        for (int i = 0; i < n; i++) {
            if (target[i] == stamp[0]) {
                bool flag = true;
                for (int j = 0; j < m; j++) {
                    if (target[i + j] != stamp[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < m; j++) {
                        s[i + j] = stamp[j];
                        vis[i + j] = true;
                    }
                    ans.push_back(i);
                }
            }
        }
        while (true) {
            bool flag = true;
            for (int i = 0; i < n; i++) {
                if (vis[i]) {
                    continue;
                }
                flag = false;
                for (int j = 0; j < m; j++) {
                    if (s[i + j] == '?') {
                        continue;
                    }
                    if (s[i + j] != stamp[j]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    for (int j = 0; j < m; j++) {
                        s[i + j] = stamp[j];
                        vis[i + j] = true;
                    }
                    ans.push_back(i);
                }
            }
            if (flag) {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (s[i] != target[i]) {
                return {};
            }
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};
class Solution {
public:
    vector<int> movesToStamp(string stamp, string target) {
        
        int m = stamp.length(), n = target.length();
        vector<int> res;
        vector<bool> vis(n, false);
        int cnt = 0;
        while (cnt < n) {
            bool done = false;
            for (int i = 0; i <= n - m; ++i) {
                if (!vis[i] && canTransform(stamp, target, i)) {
                    for (int j = 0; j < m; ++j) {
                        if (target[i + j] != '?') {
                            target[i + j] = '?';
                            ++cnt;
                        }
                    }
                    vis[i] = true;
                    done = true;
                    res.push_back(i);
                }
            }
            if (!done) {
                return {};
            }
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
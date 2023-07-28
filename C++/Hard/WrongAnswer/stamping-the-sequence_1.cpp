class Solution {
public:
    vector<int> movesToStamp(string stamp, string target) {
        
        int n = stamp.size();
        int m = target.size();
        vector<int> res;
        vector<int> visited(m, 0);
        int count = 0;
        while (count < m) {
            bool found = false;
            for (int i = 0; i <= m - n; ++i) {
                if (visited[i]) continue;
                int matched = 0;
                for (int j = 0; j < n; ++j) {
                    if (target[i + j] == '?') continue;
                    if (target[i + j] == stamp[j]) ++matched;
                    else break;
                }
                if (matched == n) {
                    found = true;
                    visited[i] = 1;
                    count += n;
                    res.push_back(i);
                    for (int j = 0; j < n; ++j) {
                        target[i + j] = '?';
                    }
                }
            }
            if (!found) return {};
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
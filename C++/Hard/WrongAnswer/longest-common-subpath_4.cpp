class Solution {
public:
    int longestCommonSubpath(int n, vector<vector<int>>& paths) {
        
        int m = paths.size();
        vector<vector<int>> h(m, vector<int>(paths[0].size()));
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < paths[i].size(); ++j) {
                h[i][j] = paths[i][j] + (j > 0 ? h[i][j - 1] : 0);
            }
        }
        int l = 0, r = paths[0].size() - 1;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid, n, paths, h)) l = mid;
            else r = mid - 1;
        }
        return l;
    }
    bool check(int len, int n, vector<vector<int>>& paths, vector<vector<int>>& h) {
        unordered_map<int, vector<int>> mp;
        for (int i = 0; i < paths.size(); ++i) {
            for (int j = 0; j + len <= paths[i].size(); ++j) {
                int hash = h[i][j + len - 1] - (j > 0 ? h[i][j - 1] : 0);
                hash = (hash * 31) % 1000000007;
                mp[hash].push_back(j);
            }
        }
        for (auto& [_, v] : mp) {
            if (v.size() == paths.size()) {
                bool flag = true;
                for (int i = 1; i < v.size(); ++i) {
                    if (v[i] - v[i - 1] < len) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return true;
            }
        }
        return false;
    }
};
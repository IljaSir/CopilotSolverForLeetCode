class Solution {
public:
    int maximumRemovals(string s, string p, vector<int>& removable) {
        
        int n = s.size();
        int m = p.size();
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (check(s, p, removable, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    bool check(string& s, string& p, vector<int>& removable, int k) {
        vector<bool> vis(s.size());
        for (int i = 0; i < k; ++i) {
            vis[removable[i]] = true;
        }
        int j = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (!vis[i] && s[i] == p[j]) {
                ++j;
            }
        }
        return j == p.size();
    }
};
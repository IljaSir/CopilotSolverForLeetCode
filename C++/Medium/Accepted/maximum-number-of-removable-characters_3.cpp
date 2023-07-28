class Solution {
public:
    int maximumRemovals(string s, string p, vector<int>& removable) {
        
        int l = 0, r = removable.size();
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (check(s, p, removable, m)) l = m;
            else r = m - 1;
        }
        return l;
    }
    bool check(string &s, string &p, vector<int> &removable, int k) {
        vector<int> vis(s.length(), 0);
        for (int i = 0; i < k; ++i) {
            vis[removable[i]] = 1;
        }
        int j = 0;
        for (int i = 0; i < s.length() && j < p.length(); ++i) {
            if (vis[i] == 0 && s[i] == p[j]) {
                ++j;
            }
        }
        return j == p.length();
    }
};
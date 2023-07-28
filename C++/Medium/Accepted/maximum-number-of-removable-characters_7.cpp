class Solution {
public:
    int maximumRemovals(string s, string p, vector<int>& removable) {
        
        int n = removable.size();
        int l = 0, r = n;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (check(s, p, removable, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
    bool check(string s, string p, vector<int>& removable, int k) {
        vector<bool> del(s.size(), false);
        for (int i = 0; i < k; i++) {
            del[removable[i]] = true;
        }
        int j = 0;
        for (int i = 0; i < s.size() && j < p.size(); i++) {
            if (!del[i] && s[i] == p[j]) {
                j++;
            }
        }
        return j == p.size();
    }
};
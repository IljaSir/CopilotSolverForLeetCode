class Solution {
public:
    int maximumRemovals(string s, string p, vector<int>& removable) {
        
        int len = removable.size();
        int l = 0, r = len;
        while(l < r) {
            int mid = (l + r + 1) / 2;
            if (check(s, p, removable, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    bool check(string s, string p, vector<int>& removable, int k) {
        int len = s.size();
        vector<bool> flag(len, false);
        for (int i = 0; i < k; i++) {
            flag[removable[i]] = true;
        }
        int j = 0;
        for (int i = 0; i < len; i++) {
            if (j == p.size()) {
                return true;
            }
            if (flag[i] == false && s[i] == p[j]) {
                j++;
            }
        }
        return j == p.size();
    }
};
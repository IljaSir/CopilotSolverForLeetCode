class Solution {
public:
    int maximumRemovals(string s, string p, vector<int>& removable) {
        
        int l = 0, r = removable.size();
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
    bool check(string s, string p, vector<int> &removable, int k) {
        int i = 0, j = 0;
        unordered_set<int> remove(removable.begin(), removable.begin() + k);
        while (i < s.size() && j < p.size()) {
            if (remove.count(i) == 0 && s[i] == p[j]) {
                j++;
            }
            i++;
        }
        return j == p.size();
    }
};
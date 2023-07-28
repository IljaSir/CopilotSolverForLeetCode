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
};
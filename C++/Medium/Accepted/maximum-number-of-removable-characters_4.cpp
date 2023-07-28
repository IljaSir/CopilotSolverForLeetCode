class Solution {
public:
    int maximumRemovals(string s, string p, vector<int>& removable) {
        
        int l = 0, r = removable.size();
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (isSubsequence(s, p, removable, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
    
    bool isSubsequence(string s, string p, vector<int>& removable, int k) {
        vector<int> marked(s.size());
        for (int i = 0; i < k; ++i) {
            marked[removable[i]] = 1;
        }
        int i = 0, j = 0;
        while (i < s.size() && j < p.size()) {
            if (marked[i] == 0 && s[i] == p[j]) {
                ++j;
            }
            ++i;
        }
        return j == p.size();
    }
};
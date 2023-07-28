class Solution {
public:
    int longestIdealString(string s, int k) {
        
        if (k == 0) return 0;
        int n = s.length();
        vector<int> left(n, 0), right(n, 0);
        int l = 0, r = 0;
        for (int i = 0; i < n; ++i) {
            l = max(l, i - (s[i] - 'a'));
            r = min(r, i + (s[i] - 'a'));
            left[i] = l;
            right[i] = r;
        }
        l = 0, r = 0;
        for (int i = n - 1; i >= 0; --i) {
            l = max(l, i - (s[i] - 'a'));
            r = min(r, i + (s[i] - 'a'));
            left[i] = max(left[i], l);
            right[i] = min(right[i], r);
        }
        int res = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (left[i] <= right[i + 1]) res = max(res, i + 2);
        }
        return res;
    }
};
class Solution {
public:
    int longestIdealString(string s, int k) {
        
        int n = s.size();
        int res = 0;
        vector<int> left(n);
        vector<int> right(n);
        left[0] = s[0] - 'a';
        for (int i = 1; i < n; ++i) {
            left[i] = min(left[i - 1], s[i] - 'a');
        }
        right[n - 1] = 'z' - s[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            right[i] = min(right[i + 1], 'z' - s[i]);
        }
        for (int i = 0; i < n; ++i) {
            if (right[i] <= k && left[i] <= k) {
                res = max(res, i + 1);
            }
        }
        return res;
    }
};
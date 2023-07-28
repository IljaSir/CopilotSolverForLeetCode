class Solution {
public:
    vector<string> maxNumOfSubstrings(string s) {
        
        int n = s.length();
        vector<int> start(26, n), end(26, -1);
        for (int i = 0; i < n; ++i) {
            int c = s[i] - 'a';
            start[c] = min(start[c], i);
            end[c] = max(end[c], i);
        }
        vector<int> left(n, -1), right(n, n);
        for (int i = 0; i < 26; ++i) {
            if (start[i] < n) {
                int l = start[i], r = end[i];
                while (l < r) {
                    if (left[l] == -1) {
                        left[l] = i;
                    }
                    if (right[r] == n) {
                        right[r] = i;
                    }
                    ++l;
                    --r;
                }
            }
        }
        vector<string> ans;
        int i = 0;
        while (i < n) {
            int c = left[i];
            int r = end[c];
            while (i <= r) {
                c = left[i];
                r = max(r, end[c]);
                ++i;
            };
        }
        return ans;
    }
};
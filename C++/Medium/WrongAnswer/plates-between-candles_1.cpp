class Solution {
public:
    vector<int> platesBetweenCandles(string s, vector<vector<int>>& queries) {
        
        vector<int> res;
        int n = s.length();
        vector<int> left(n, 0);
        vector<int> right(n, 0);
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == '*') {
                cnt++;
            }
            left[i] = cnt;
        }
        cnt = 0;
        for (int i = n - 1; i >= 0; --i) {
            if (s[i] == '*') {
                cnt++;
            }
            right[i] = cnt;
        }
        for (auto& q : queries) {
            int l = q[0];
            int r = q[1];
            res.push_back(left[r] - left[l] - (s[l] == '*' ? 1 : 0));
        }
        return res;
    }
};
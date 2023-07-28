class Solution {
public:
    int minFlipsMonoIncr(string s) {
        
        int n = s.length();
        vector<int> zero(n, 0);
        vector<int> one(n, 0);
        if (s[0] == '0') {
            zero[0] = 1;
        } else {
            one[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (s[i] == '0') {
                zero[i] = zero[i - 1] + 1;
                one[i] = one[i - 1];
            } else {
                zero[i] = zero[i - 1];
                one[i] = one[i - 1] + 1;
            }
        }
        int ans = INT_MAX;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            if (i == 0) {
                cur = one[n - 1];
            } else if (i == n - 1) {
                cur = zero[n - 1];
            } else {
                cur = zero[i] + (one[n - 1] - one[i]);
            }
            ans = min(ans, cur);
        }
        return ans;
    }
};
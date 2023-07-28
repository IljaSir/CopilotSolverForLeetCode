class Solution {
public:
    long long sumScores(string s) {
        
        int n = s.size();
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            int j = i, k = n - 1;
            while (j < n && s[j] == s[k]) {
                ++j;
                --k;
            }
            ans += (j - i);
            i = j - 1;
        }
        return ans;
    }
};
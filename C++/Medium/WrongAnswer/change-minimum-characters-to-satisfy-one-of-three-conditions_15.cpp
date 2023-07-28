class Solution {
public:
    int minCharacters(string a, string b) {
        
        int n = a.size();
        int m = b.size();
        int ans = n + m;
        vector<int> cnt(26);
        for (int i = 0; i < n; ++i) {
            ++cnt[a[i] - 'a'];
        }
        for (int i = 0; i < m; ++i) {
            ++cnt[b[i] - 'a'];
        }
        for (int i = 0; i < 26; ++i) {
            int t = n + m - cnt[i];
            ans = min(ans, t);
        }
        for (int i = 1; i < 26; ++i) {
            int t = 0;
            for (int j = 0; j < i; ++j) {
                t += cnt[j];
            }
            for (int j = i; j < 26; ++j) {
                t += n - cnt[j];
            }
            ans = min(ans, t);
        }
        for (int i = 0; i < 25; ++i) {
            int t = 0;
            for (int j = 0; j <= i; ++j) {
                t += n - cnt[j];
            }
            for (int j = i + 1; j < 26; ++j) {
                t += m - cnt[j];
            }
            ans = min(ans, t);
        }
        return ans;
    }
};
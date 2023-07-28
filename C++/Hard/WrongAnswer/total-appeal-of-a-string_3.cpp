class Solution {
public:
    long long appealSum(string s) {
        
        int n = s.size();
        long long res = 0;
        vector<int> cnt(26, 0);
        for (int i = 0; i < n; ++i) {
            int ch = s[i] - 'a';
            cnt[ch]++;
            int tmp = 0;
            for (int j = 0; j < 26; ++j) {
                if (cnt[j] > 0) {
                    tmp++;
                }
            }
            res += tmp;
        }
        return res;
    }
};
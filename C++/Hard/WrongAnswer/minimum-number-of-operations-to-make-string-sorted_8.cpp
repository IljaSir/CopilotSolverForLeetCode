class Solution {
public:
    int makeStringSorted(string s) {
        
        vector<int> cnt(26);
        for (auto c : s) {
            ++cnt[c - 'a'];
        }
        long long res = 0, fact = 1;
        for (int i = 0; i < s.size(); ++i) {
            fact = fact * (i + 1) % 1000000007;
            for (int j = 0; j < s[i] - 'a'; ++j) {
                if (cnt[j]) {
                    long long cur = fact;
                    for (int k = 0; k < 26; ++k) {
                        if (k != j) {
                            for (int l = 1; l <= cnt[k]; ++l) {
                                cur = cur * l % 1000000007;
                            }
                        }
                    }
                    res = (res + cur * cnt[j]) % 1000000007;
                }
            }
            --cnt[s[i] - 'a'];
        }
        return res;
    }
};
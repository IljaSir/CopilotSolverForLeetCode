class Solution {
public:
    string removeDuplicates(string s, int k) {
        
        int n = s.size();
        vector<int> cnt(n, 1);
        for (int i = 0; i < n; ++i) {
            if (i > 0 && s[i] == s[i - 1]) {
                cnt[i] = cnt[i - 1] + 1;
                if (cnt[i] == k) {
                    s.erase(i - k + 1, k);
                    i = i - k;
                    n = s.size();
                }
            }
        }
        return s;
    }
};
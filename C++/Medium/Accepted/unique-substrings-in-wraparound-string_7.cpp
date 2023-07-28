class Solution {
public:
    int findSubstringInWraproundString(string s) {
        
        int n = s.size();
        if (n == 0) return 0;
        unordered_map<char, int> m;
        int len = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && (s[i] - s[i-1] == 1 || s[i-1] - s[i] == 25)) {
                len++;
            } else {
                len = 1;
            }
            m[s[i]] = max(m[s[i]], len);
        }
        int res = 0;
        for (auto p : m) {
            res += p.second;
        }
        return res;
    }
};
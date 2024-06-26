class Solution {
public:
    string longestDupSubstring(string s) {
        
        int n = s.size();
        int l = 0, r = n - 1;
        int mid;
        int idx;
        while (l <= r) {
            mid = l + (r - l) / 2;
            idx = search(s, mid);
            if (idx != -1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return s.substr(idx, l - 1);
    }
    int search(string& s, int len) {
        int n = s.size();
        long long h = 0;
        long long base = 1;
        long long mod = (1LL << 31) - 1;
        unordered_set<long long> hash;
        for (int i = 0; i < len; ++i) {
            h = (h * 26 + s[i] - 'a') % mod;
            base = (base * 26) % mod;
        }
        hash.insert(h);
        for (int i = len; i < n; ++i) {
            h = (h * 26 + s[i] - 'a') % mod;
            h = (h - (s[i - len] - 'a') * base % mod + mod) % mod;
            if (hash.count(h)) {
                return i - len + 1;
            }
            hash.insert(h);
        }
        return -1;
    }
};
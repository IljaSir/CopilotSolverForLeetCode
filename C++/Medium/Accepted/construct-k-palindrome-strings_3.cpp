class Solution {
public:
    bool canConstruct(string s, int k) {
        
        int n = s.size();
        if (n < k) return false;
        if (n == k) return true;
        vector<int> cnt(26, 0);
        for (auto c : s) {
            cnt[c - 'a']++;
        }
        int odd = 0;
        for (auto c : cnt) {
            if (c & 1) odd++;
        }
        return odd <= k;
    }
};
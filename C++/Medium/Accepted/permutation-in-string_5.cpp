class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        
        int n = s1.length(), m = s2.length();
        if (n > m) return false;
        vector<int> cnt(26, 0);
        for (auto c : s1) cnt[c - 'a']++;
        int l = 0, r = 0;
        while (r < m) {
            cnt[s2[r] - 'a']--;
            while (l <= r && cnt[s2[r] - 'a'] < 0) {
                cnt[s2[l] - 'a']++;
                l++;
            }
            if (r - l + 1 == n) return true;
            r++;
        }
        return false;
    }
};
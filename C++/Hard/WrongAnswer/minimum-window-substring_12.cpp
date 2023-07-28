class Solution {
public:
    string minWindow(string s, string t) {
        
        int n = s.size();
        int m = t.size();
        if (n < m) return "";
        int cnt[256];
        int need[256];
        memset(cnt, 0, sizeof(cnt));
        memset(need, 0, sizeof(need));
        for (auto c : t) {
            need[c]++;
        }
        int found = 0;
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = n;
        while (right < n) {
            if (need[s[right]] > 0) {
                cnt[s[right]]++;
                if (cnt[s[right]] <= need[s[right]]) {
                    found++;
                }
            }
            right++;
            while (found == m) {
                if (right - left < minRight - minLeft) {
                    minLeft = left;
                    minRight = right;
                }
                if (need[s[left]] > 0) {
                    cnt[s[left]]--;
                    if (cnt[s[left]] < need[s[left]]) {
                        found--;
                    }
                }
                left++;
            }
        }
        if (minRight == n) {
            return "";
        }
        return s.substr(minLeft, minRight - minLeft);
    }
};
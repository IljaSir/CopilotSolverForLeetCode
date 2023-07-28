class Solution {
public:
    int minSteps(string s, string t) {
        
        int cnt[26] = {0};
        for (auto c : s) {
            cnt[c-'a']++;
        }
        for (auto c : t) {
            cnt[c-'a']--;
        }
        int ans = 0;
        for (auto c : cnt) {
            if (c > 0) {
                ans += c;
            }
        }
        return ans;
    }
};
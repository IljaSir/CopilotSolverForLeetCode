class Solution {
public:
    int minSteps(string s, string t) {
        
        vector<int> cnt(26, 0);
        for (char c : s) {
            cnt[c - 'a']++;
        }
        int res = 0;
        for (char c : t) {
            if (cnt[c - 'a'] > 0) {
                cnt[c - 'a']--;
            } else {
                res++;
            }
        }
        return res;
    }
};
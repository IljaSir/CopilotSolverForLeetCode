class Solution {
public:
    int maxVowels(string s, int k) {
        
        int n = s.size();
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            cnt += isVowel(s[i]);
            if (i >= k) {
                cnt -= isVowel(s[i - k]);
            }
            ans = max(ans, cnt);
        }
        return ans;
    }
};
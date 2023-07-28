class Solution {
public:
    int longestIdealString(string s, int k) {
        
        int n = s.length();
        vector<int> cnt(26, 0);
        int i = 0, j = 0, res = 0;
        while (j < n) {
            cnt[s[j] - 'a']++;
            while (i < j && cnt[s[j] - 'a'] - cnt[s[i] - 'a'] > k) {
                cnt[s[i] - 'a']--;
                i++;
            }
            res = max(res, j - i + 1);
            j++;
        }
        return res;
    }
};
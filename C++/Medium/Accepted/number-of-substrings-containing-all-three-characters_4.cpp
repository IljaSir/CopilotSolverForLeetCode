class Solution {
public:
    int numberOfSubstrings(string s) {
        
        int n = s.size();
        int res = 0;
        int i = 0, j = 0;
        vector<int> cnt(3, 0);
        while (j < n) {
            cnt[s[j] - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                cnt[s[i] - 'a']--;
                i++;
            }
            res += i;
            j++;
        }
        return res;
    }
};
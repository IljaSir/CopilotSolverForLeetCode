class Solution {
public:
    int numSplits(string s) {
        
        int n = s.size();
        int ans = 0;
        vector<int> l(26, 0);
        vector<int> r(26, 0);
        for (int i = 0; i < n; i++) {
            r[s[i] - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            l[s[i] - 'a']++;
            r[s[i] - 'a']--;
            int lc = 0, rc = 0;
            for (int j = 0; j < 26; j++) {
                if (l[j] > 0) lc++;
                if (r[j] > 0) rc++;
            }
            if (lc == rc) ans++;
        }
        return ans;
    }
};
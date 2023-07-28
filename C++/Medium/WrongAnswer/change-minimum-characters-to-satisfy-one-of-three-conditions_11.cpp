class Solution {
public:
    int minCharacters(string a, string b) {
        
        int ans = INT_MAX;
        vector<int> cntA(26, 0), cntB(26, 0);
        for (char c : a) cntA[c - 'a']++;
        for (char c : b) cntB[c - 'a']++;
        for (int i = 0; i < 25; ++i) {
            int ca = 0, cb = 0;
            for (int j = 0; j < 26; ++j) {
                if (j <= i) ca += cntA[j];
                if (j > i) cb += cntB[j];
            }
            ans = min(ans, ca + cb);
        }
        for (int i = 0; i < 25; ++i) {
            int ca = 0, cb = 0;
            for (int j = 0; j < 26; ++j) {
                if (j <= i) cb += cntB[j];
                if (j > i) ca += cntA[j];
            }
            ans = min(ans, ca + cb);
        }
        int ca = 0, cb = 0;
        for (int j = 0; j < 26; ++j) {
            ca += cntA[j];
            cb += cntB[j];
        }
        ans = min(ans, ca + cb - max(cntA[0], cntB[0]));
        return ans;
    }
};
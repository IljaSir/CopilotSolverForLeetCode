class Solution {
public:
    bool checkIfCanBreak(string s1, string s2) {
        
        int n = s1.size();
        int a[26] = {0};
        int b[26] = {0};
        for (int i = 0; i < n; i++) {
            a[s1[i] - 'a']++;
            b[s2[i] - 'a']++;
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < 26; i++) {
            cnt1 += a[i];
            cnt2 += b[i];
            if (cnt1 < cnt2) return false;
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 25; i >= 0; i--) {
            cnt1 += a[i];
            cnt2 += b[i];
            if (cnt1 < cnt2) return false;
        }
        return true;
    }
};
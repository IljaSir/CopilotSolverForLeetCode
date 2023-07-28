class Solution {
public:
    int minimumSwap(string s1, string s2) {
        
        int xy = 0, yx = 0;
        for (int i = 0; i < s1.size(); i++) {
            if (s1[i] == s2[i]) continue;
            if (s1[i] == 'x') xy++;
            else yx++;
        }
        if ((xy + yx) % 2 == 1) return -1;
        int ans = 0;
        ans += xy / 2;
        ans += yx / 2;
        ans += xy % 2 * 2;
        return ans;
    }
};
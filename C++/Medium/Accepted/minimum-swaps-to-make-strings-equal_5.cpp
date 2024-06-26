class Solution {
public:
    int minimumSwap(string s1, string s2) {
        
        int xy = 0, yx = 0;
        for (int i = 0; i < s1.size(); i++) {
            if (s1[i] == s2[i]) continue;
            if (s1[i] == 'x') xy++;
            else yx++;
        }
        int ans = xy / 2 + yx / 2;
        xy %= 2;
        yx %= 2;
        if (xy + yx == 1) return -1;
        if (xy == 1) ans += 2;
        return ans;
    }
};
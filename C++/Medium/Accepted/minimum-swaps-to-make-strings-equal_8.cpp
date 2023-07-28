class Solution {
public:
    int minimumSwap(string s1, string s2) {
        
        int n = s1.size();
        int xy = 0, yx = 0;
        for (int i = 0; i < n; i++) {
            if (s1[i] == 'x' && s2[i] == 'y') xy++;
            if (s1[i] == 'y' && s2[i] == 'x') yx++;
        }
        int ans = xy / 2 + yx / 2;
        xy %= 2;
        yx %= 2;
        if (xy == 1 && yx == 1) ans += 2;
        else if (xy == 1 || yx == 1) return -1;
        return ans;
    }
};
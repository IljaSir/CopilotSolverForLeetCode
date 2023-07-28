class Solution {
public:
    int minimumSwap(string s1, string s2) {
        
        int n = s1.size();
        int xy = 0;
        int yx = 0;
        for (int i = 0; i < n; ++i) {
            if (s1[i] == 'x' && s2[i] == 'y') {
                ++xy;
            } else if (s1[i] == 'y' && s2[i] == 'x') {
                ++yx;
            }
        }
        if ((xy + yx) % 2) {
            return -1;
        }
        int ans = xy / 2 + yx / 2;
        if (xy % 2) {
            ans += 2;
        }
        return ans;
    }
};
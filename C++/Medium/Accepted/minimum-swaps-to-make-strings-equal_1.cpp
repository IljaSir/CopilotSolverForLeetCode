class Solution {
public:
    int minimumSwap(string s1, string s2) {
        
        int xy = 0, yx = 0;
        for (int i = 0; i < s1.size(); i++) {
            if (s1[i] == 'x' && s2[i] == 'y') {
                xy++;
            } else if (s1[i] == 'y' && s2[i] == 'x') {
                yx++;
            }
        }
        return (xy + yx) % 2 == 1 ? -1 : xy / 2 + yx / 2 + (xy % 2) * 2;
    }
};
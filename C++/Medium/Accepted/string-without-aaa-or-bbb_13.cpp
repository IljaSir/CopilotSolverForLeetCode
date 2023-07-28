class Solution {
public:
    string strWithout3a3b(int a, int b) {
        
        string s;
        int aa = 0, bb = 0;
        while (a || b) {
            if (aa == 2) {
                s += 'b';
                bb++;
                aa = 0;
                b--;
            } else if (bb == 2) {
                s += 'a';
                aa++;
                bb = 0;
                a--;
            } else if (a > b) {
                s += 'a';
                aa++;
                bb = 0;
                a--;
            } else {
                s += 'b';
                bb++;
                aa = 0;
                b--;
            }
        }
        return s;
    }
};
class Solution {
public:
    bool checkZeroOnes(string s) {
        
        int l0 = 0, l1 = 0;
        int c0 = 0, c1 = 0;
        for (auto c : s) {
            if (c == '0') {
                c0++;
                if (c1 > l1) {
                    l1 = c1;
                }
                c1 = 0;
            } else {
                c1++;
                if (c0 > l0) {
                    l0 = c0;
                }
                c0 = 0;
            }
        }
        if (c0 > l0) {
            l0 = c0;
        }
        if (c1 > l1) {
            l1 = c1;
        }
        return l1 > l0;
    }
};
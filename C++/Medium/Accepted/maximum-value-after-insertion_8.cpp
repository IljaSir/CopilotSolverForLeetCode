class Solution {
public:
    string maxValue(string n, int x) {
        
        int i = 0;
        int len = n.length();
        bool neg = false;
        if (n[0] == '-') {
            neg = true;
            i = 1;
        }
        if (!neg) {
            while (i < len && n[i] - '0' >= x) {
                i++;
            }
            n.insert(i, 1, x + '0');
        } else {
            while (i < len && n[i] - '0' <= x) {
                i++;
            }
            n.insert(i, 1, x + '0');
        }
        return n;
    }
};
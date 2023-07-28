class Solution {
public:
    string maxValue(string n, int x) {
        
        bool isNegative = n[0] == '-';
        int i = isNegative ? 1 : 0;
        for (; i < n.size(); ++i) {
            if (isNegative && n[i] - '0' <= x) {
                n.insert(i, 1, x + '0');
                return n;
            }
            if (!isNegative && n[i] - '0' >= x) {
                n.insert(i, 1, x + '0');
                return n;
            }
        }
        n.insert(i, 1, x + '0');
        return n;
    }
};
class Solution {
public:
    vector<int> pathInZigZagTree(int label) {
        
        vector<int> ret;
        int level = 0;
        int base = 1;
        while (label >= base) {
            base <<= 1;
            level++;
        }
        base >>= 1;
        level--;
        while (level >= 0) {
            ret.push_back(label);
            label = (base + (base - 1 - label) / 2);
            base >>= 1;
            level--;
        }
        reverse(ret.begin(), ret.end());
        return ret;
    }
};
class Solution {
public:
    vector<int> pathInZigZagTree(int label) {
        
        int level = 1;
        while (pow(2, level) - 1 < label) level++;
        vector<int> res(level);
        while (level > 0) {
            res[level - 1] = label;
            label = (pow(2, level) - 1 + pow(2, level - 1) - label) / 2;
            level--;
        }
        return res;
    }
};
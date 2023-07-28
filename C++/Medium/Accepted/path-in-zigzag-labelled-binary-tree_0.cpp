class Solution {
public:
    vector<int> pathInZigZagTree(int label) {
        
        vector<int> res;
        int level = log2(label);
        while (label > 0) {
            res.push_back(label);
            label = (1 << level) + (1 << (level + 1)) - 1 - label;
            label >>= 1;
            level--;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
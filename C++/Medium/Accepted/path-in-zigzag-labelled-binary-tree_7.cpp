class Solution {
public:
    vector<int> pathInZigZagTree(int label) {
        
        vector<int> res;
        int level = 0;
        while ((1 << level) <= label) {
            level++;
        }
        while (label != 1) {
            res.push_back(label);
            int start = (1 << (level - 1));
            int end = (1 << level) - 1;
            label = start + end - label;
            label /= 2;
            level--;
        }
        res.push_back(1);
        reverse(res.begin(), res.end());
        return res;
    }
};
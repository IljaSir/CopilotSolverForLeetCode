class Solution {
public:
    vector<int> pathInZigZagTree(int label) {
        
        int level = 0;
        for (int i = 1; i <= label; i <<= 1) {
            level++;
        }
        vector<int> res;
        while (label > 0) {
            res.push_back(label);
            int start = 1 << (level - 1);
            int end = (1 << level) - 1;
            label = (start + end - label) / 2;
            level--;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
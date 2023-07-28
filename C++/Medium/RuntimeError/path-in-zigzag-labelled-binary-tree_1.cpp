class Solution {
public:
    vector<int> pathInZigZagTree(int label) {
        
        vector<int> res;
        int h = 0;
        while (label > 0) {
            res.push_back(label);
            label /= 2;
            h++;
        }
        reverse(res.begin(), res.end());
        for (int i = 1; i < h; i += 2) {
            int n = 1 << i;
            int m = 1 << (i+1);
            for (int j = 0; j < n; j++) {
                res[j+i] = m - 1 - res[j+i];
            }
        }
        return res;
    }
};
class Solution {
public:
    vector<int> pathInZigZagTree(int label) {
        
        int n = 1;
        while (n * 2 - 1 < label) n *= 2;
        vector<int> res;
        while (n > 0) {
            res.push_back(label);
            label = n + n - 1 - label / 2;
            n /= 2;
        }
        reverse(res.begin(), res.end());
        return res;
    }
};
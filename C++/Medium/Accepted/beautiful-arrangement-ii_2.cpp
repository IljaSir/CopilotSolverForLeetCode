class Solution {
public:
    vector<int> constructArray(int n, int k) {
        
        vector<int> res;
        int l = 1, r = n;
        while (l <= r) {
            if (k > 1) {
                if (k % 2 == 0) {
                    res.push_back(r--);
                } else {
                    res.push_back(l++);
                }
                k--;
            } else {
                res.push_back(l++);
            }
        }
        return res;
    }
};
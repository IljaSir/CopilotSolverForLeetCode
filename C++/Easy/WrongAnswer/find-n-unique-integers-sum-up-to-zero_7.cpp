class Solution {
public:
    vector<int> sumZero(int n) {
        
        vector<int> res;
        int i = 0;
        if (n % 2 == 1) {
            res.push_back(0);
            i = 1;
        }
        for (; i < n; i += 2) {
            res.push_back(-i);
            res.push_back(i+1);
        }
        return res;
    }
};
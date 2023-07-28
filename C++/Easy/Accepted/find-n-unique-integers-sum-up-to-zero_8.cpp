class Solution {
public:
    vector<int> sumZero(int n) {
        
        vector<int> ret;
        if (n == 1) {
            ret.push_back(0);
            return ret;
        }
        int i = 1;
        while (i <= n/2) {
            ret.push_back(i);
            ret.push_back(-i);
            i++;
        }
        if (n % 2 != 0) {
            ret.push_back(0);
        }
        return ret;
    }
};
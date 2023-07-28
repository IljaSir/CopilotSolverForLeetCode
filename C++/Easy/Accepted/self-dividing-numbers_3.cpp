class Solution {
public:
    vector<int> selfDividingNumbers(int left, int right) {
        
        vector<int> res;
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                res.push_back(i);
            }
        }
        return res;
    }
    
    bool isSelfDividing(int num) {
        int tmp = num;
        while (tmp) {
            int d = tmp % 10;
            if (d == 0 || num % d != 0) {
                return false;
            }
            tmp /= 10;
        }
        return true;
    }
};
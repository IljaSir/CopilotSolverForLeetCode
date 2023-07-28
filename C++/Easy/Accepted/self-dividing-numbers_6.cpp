class Solution {
public:
    vector<int> selfDividingNumbers(int left, int right) {
        
        vector<int> res;
        for (int i = left; i <= right; i++) {
            if (selfDividing(i)) {
                res.push_back(i);
            }
        }
        return res;
    }
    
    bool selfDividing(int num) {
        int tmp = num;
        while (tmp > 0) {
            int digit = tmp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            tmp /= 10;
        }
        return true;
    }
};
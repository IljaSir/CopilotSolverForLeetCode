class Solution {
public:
    vector<int> selfDividingNumbers(int left, int right) {
        
        vector<int> result;
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                result.push_back(i);
            }
        }
        return result;
    }
    
    bool isSelfDividingNumber(int n) {
        int tmp = n;
        while (tmp > 0) {
            int mod = tmp % 10;
            if (mod == 0) {
                return false;
            }
            if (n % mod != 0) {
                return false;
            }
            tmp /= 10;
        }
        return true;
    }
};
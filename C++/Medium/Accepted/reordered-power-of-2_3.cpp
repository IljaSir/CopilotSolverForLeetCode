class Solution {
public:
    bool reorderedPowerOf2(int n) {
        
        vector<int> digits;
        while (n) {
            digits.push_back(n % 10);
            n /= 10;
        }
        sort(digits.begin(), digits.end());
        do {
            if (digits[0] != 0) {
                int num = 0;
                for (int i = 0; i < digits.size(); i++) {
                    num = num * 10 + digits[i];
                }
                if (__builtin_popcount(num) == 1) {
                    return true;
                }
            }
        } while (next_permutation(digits.begin(), digits.end()));
        return false;
    }
};
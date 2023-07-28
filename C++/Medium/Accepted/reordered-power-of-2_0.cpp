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
            if (digits[0] == 0) continue;
            int m = 0;
            for (int d : digits) {
                m = m * 10 + d;
            }
            if ((m & (m - 1)) == 0) return true;
        } while (next_permutation(digits.begin(), digits.end()));
        return false;
    }
};
class Solution {
public:
    vector<int> evenOddBit(int n) {
        
        int even = 0, odd = 0;
        int i = 0;
        while (n > 0) {
            if (n & 1) {
                if (i & 1) {
                    odd++;
                } else {
                    even++;
                }
            }
            n >>= 1;
            i++;
        }
        return {even, odd};
    }
};
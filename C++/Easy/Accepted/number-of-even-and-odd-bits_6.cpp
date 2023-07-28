class Solution {
public:
    vector<int> evenOddBit(int n) {
        
        int even = 0, odd = 0;
        for (int i = 0; i <= 31; i++) {
            if (i % 2 == 0) {
                if (n & (1 << i)) {
                    even++;
                }
            } else {
                if (n & (1 << i)) {
                    odd++;
                }
            }
        }
        return {even, odd};
    }
};
class Solution {
public:
    int countPrimeSetBits(int left, int right) {
        
        int count = 0;
        for (int i = left; i <= right; ++i) {
            int num = i;
            int setBits = 0;
            while (num > 0) {
                if (num & 1) {
                    ++setBits;
                }
                num >>= 1;
            }
            if (setBits == 2 || setBits == 3 || setBits == 5 || setBits == 7 || setBits == 11 || setBits == 13 || setBits == 17 || setBits == 19) {
                ++count;
            }
        }
        return count;
    }
};
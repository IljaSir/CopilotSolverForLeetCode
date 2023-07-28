class Solution {
public:
    int smallestEvenMultiple(int n) {
        
        int i = 2;
        while (true) {
            if (i % n == 0) {
                return i;
            }
            i += 2;
        }
    }
};
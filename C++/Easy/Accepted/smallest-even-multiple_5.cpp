class Solution {
public:
    int smallestEvenMultiple(int n) {
        
        int i = 2;
        while (true) {
            if (i % n == 0 && i % 2 == 0) {
                return i;
            }
            i++;
        }
    }
};
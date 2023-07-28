class Solution {
public:
    int reinitializePermutation(int n) {
        
        int count = 0;
        int p = 1;
        do {
            if (p < n / 2) {
                p *= 2;
            } else {
                p = 2 * (p - n / 2) + 1;
            }
            count++;
        } while (p != 1);
        return count;
    }
};
class Solution {
public:
    int reinitializePermutation(int n) {
        
        int count = 0;
        int i = 1;
        do {
            if (i < n / 2) {
                i *= 2;
            } else {
                i = (i - n / 2) * 2 + 1;
            }
            count++;
        } while (i != 1);
        return count;
    }
};
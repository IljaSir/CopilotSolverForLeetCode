class Solution {
public:
    int minimumBoxes(int n) {
        
        int k = 0;
        while (n > k * (k + 1) / 2) {
            k++;
        }
        int t = k * (k + 1) / 2, i = 0;
        while (t > n) {
            t -= k - i;
            i++;
        }
        return k * (k + 1) / 2 - i * (i + 1) / 2;
    }
};
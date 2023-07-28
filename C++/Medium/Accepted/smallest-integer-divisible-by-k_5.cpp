class Solution {
public:
    int smallestRepunitDivByK(int k) {
        
        if (k % 2 == 0 || k % 5 == 0) return -1;
        int n = 1;
        int i = 1;
        while (n % k != 0) {
            n = (n % k) * 10 + 1;
            i++;
        }
        return i;
    }
};
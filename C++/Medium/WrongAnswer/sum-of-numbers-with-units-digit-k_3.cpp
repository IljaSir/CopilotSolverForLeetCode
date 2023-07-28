class Solution {
public:
    int minimumNumbers(int num, int k) {
        
        if (num == 0) return 0;
        if (k == 0) return -1;
        int res = num / k;
        if (num % k != 0) res++;
        return res;
    }
};
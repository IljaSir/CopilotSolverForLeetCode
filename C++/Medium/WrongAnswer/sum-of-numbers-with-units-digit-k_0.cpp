class Solution {
public:
    int minimumNumbers(int num, int k) {
        
        if (num == 0) return 0;
        if (num < k) return -1;
        if (num % k == 0) return num / k;
        return num / k + 1;
    }
};
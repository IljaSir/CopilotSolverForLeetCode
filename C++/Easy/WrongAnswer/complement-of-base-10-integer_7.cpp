class Solution {
public:
    int bitwiseComplement(int n) {
        
        int res = 0, i = 0;
        while (n > 0) {
            if (n % 2 == 0) res += pow(2, i);
            i++;
            n /= 2;
        }
        return res;
    }
};
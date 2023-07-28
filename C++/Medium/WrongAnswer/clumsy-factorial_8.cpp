class Solution {
public:
    int clumsy(int n) {
        
        int res = 0;
        int count = 1;
        int num = n;
        while (num > 0) {
            if (count == 1) {
                res += num;
            } else if (count == 2) {
                res -= num;
            } else if (count == 3) {
                res *= num;
            } else if (count == 4) {
                res /= num;
            }
            if (count == 4) {
                count = 1;
            } else {
                count++;
            }
            num--;
        }
        if (count == 2) {
            res += 1;
        } else if (count == 3) {
            res += 2;
        } else if (count == 4) {
            res += 6;
        }
        return res;
    }
};
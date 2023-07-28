class Solution {
public:
    int clumsy(int n) {
        
        int result = 0;
        int temp = 0;
        int i = 0;
        while (n > 0) {
            if (i == 0) {
                temp = n;
            } else if (i == 1) {
                temp *= n;
            } else if (i == 2) {
                temp /= n;
            } else if (i == 3) {
                result += temp;
                temp = n;
            } else {
                result -= temp;
                temp = n;
            }
            n--;
            i++;
            if (i == 4) {
                i = 0;
            }
        }
        if (i == 0) {
            result += temp;
        } else if (i == 1) {
            result += temp;
        } else if (i == 2) {
            result += temp;
        } else if (i == 3) {
            result += temp;
        }
        return result;
    }
};
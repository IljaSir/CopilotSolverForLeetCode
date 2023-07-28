class Solution {
public:
    int maximum69Number (int num) {
        
        int n = num;
        int i = 0;
        while (n) {
            if (n % 10 == 6) {
                num += 3 * pow(10, i);
                break;
            }
            n /= 10;
            i++;
        }
        return num;
    }
};
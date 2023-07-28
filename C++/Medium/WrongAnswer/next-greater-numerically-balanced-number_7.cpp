class Solution {
public:
    int nextBeautifulNumber(int n) {
        
        int result = 0;
        int count = 0;
        int temp = n;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        if (count == 0) {
            return 22;
        }
        temp = n;
        int i = 0;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0) {
                result += 2 * pow(10, i);
                temp /= 10;
                i++;
                continue;
            }
            if (digit > 3) {
                result += (digit - 3) * pow(10, i);
                temp /= 10;
                i++;
                continue;
            }
            if (digit == 3) {
                result += 3 * pow(10, i);
                temp /= 10;
                i++;
                continue;
            }
            if (digit == 2) {
                result += 2 * pow(10, i);
                temp /= 10;
                i++;
                continue;
            }
            if (digit == 1) {
                result += 1 * pow(10, i);
                temp /= 10;
                i++;
                continue;
            }
        }
        return result;
    }
};
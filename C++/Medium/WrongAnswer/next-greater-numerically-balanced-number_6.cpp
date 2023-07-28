class Solution {
public:
    int nextBeautifulNumber(int n) {
        
        int a[10] = {0};
        int tmp = n;
        while (tmp) {
            a[tmp % 10]++;
            tmp /= 10;
        }
        int i = 0;
        while (i < 10) {
            if (a[i] == i) {
                i++;
            } else if (a[i] > i) {
                n = n + pow(10, i) * (a[i] - i);
                i++;
            } else {
                n = n + pow(10, i) * (i - a[i]);
                break;
            }
        }
        return n;
    }
};
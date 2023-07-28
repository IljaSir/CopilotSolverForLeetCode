class Solution {
public:
    int countSpecialNumbers(int n) {
        
        int d, i, j, k, m, r, t, w, x;
        int a[10];
        for (i = 0; i < 10; i++)
            a[i] = 0;
        m = 0;
        for (i = 1; i <= n; i++) {
            t = i;
            while (t > 0) {
                d = t % 10;
                a[d]++;
                t = t / 10;
            }
            for (j = 0; j < 10; j++) {
                if (a[j] > 1)
                    break;
            }
            if (j == 10)
                m++;
            for (k = 0; k < 10; k++)
                a[k] = 0;
        }
        return m;
    }
};
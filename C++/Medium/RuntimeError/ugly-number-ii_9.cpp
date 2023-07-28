class Solution {
public:
    int nthUglyNumber(int n) {
        
        static int ugly[] = {1};
        static int i2 = 0, i3 = 0, i5 = 0;
        static int n2 = 2, n3 = 3, n5 = 5;
        static int k = 1;
        while (k < n) {
            int next = min(n2, min(n3, n5));
            ugly[k++] = next;
            if (next == n2) n2 = 2 * ugly[++i2];
            if (next == n3) n3 = 3 * ugly[++i3];
            if (next == n5) n5 = 5 * ugly[++i5];
        }
        return ugly[n-1];
    }
};
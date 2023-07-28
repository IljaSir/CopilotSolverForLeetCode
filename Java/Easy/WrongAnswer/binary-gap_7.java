class Solution {
    public int binaryGap(int n) {
        
        int a = 0, b = 0, c = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                a = b;
                b = c;
                if (a != 0) {
                    a = b - a;
                }
            }
            n /= 2;
            c++;
        }
        return a;
    }
}
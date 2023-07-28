class Solution {
    public int maxDiff(int num) {
        
        int a = -1, b = -1;
        int[] digits = new int[8];
        int n = num;
        int i = 0;
        while (n > 0) {
            digits[i++] = n % 10;
            n /= 10;
        }
        for (int j = 0; j < i; j++) {
            int x = digits[j];
            if (a == -1 && x != 9) {
                a = num + (9 - x) * (int)Math.pow(10, j);
            }
            if (x != 1) {
                if (b == -1) {
                    b = num + (1 - x) * (int)Math.pow(10, j);
                }
            } else {
                if (b == -1) {
                    int k = j + 1;
                    while (k < i && digits[k] == 1) {
                        k++;
                    }
                    if (k < i) {
                        b = num + (1 - digits[k]) * (int)Math.pow(10, k);
                    }
                }
            }
        }
        return a - b;
    }
}
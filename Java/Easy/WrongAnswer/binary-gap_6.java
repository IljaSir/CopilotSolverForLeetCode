class Solution {
    public int binaryGap(int n) {
        
        int i = 0, j = 0, max = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                if (j == 0) {
                    j = i;
                } else {
                    max = Math.max(max, i - j);
                    j = i;
                }
            }
            n = n / 2;
            i++;
        }
        return max;
    }
}
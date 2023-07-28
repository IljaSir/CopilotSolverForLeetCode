class Solution {
    public boolean reorderedPowerOf2(int n) {
        
        int[] count = new int[10];
        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 31; i++) {
            int[] c = new int[10];
            int m = 1 << i;
            while (m > 0) {
                c[m % 10]++;
                m /= 10;
            }
            if (Arrays.equals(count, c)) {
                return true;
            }
        }
        return false;
    }
}
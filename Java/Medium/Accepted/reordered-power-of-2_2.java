class Solution {
    public boolean reorderedPowerOf2(int n) {
        
        int[] count = new int[10];
        while (n > 0) {
            count[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 31; i++) {
            int[] count2 = new int[10];
            int m = 1 << i;
            while (m > 0) {
                count2[m % 10]++;
                m /= 10;
            }
            if (Arrays.equals(count, count2)) {
                return true;
            }
        }
        return false;
    }
}
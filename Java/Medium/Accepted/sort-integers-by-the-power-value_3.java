class Solution {
    public int getKth(int lo, int hi, int k) {
        
        int[] powers = new int[hi - lo + 1];
        for (int i = 0; i < powers.length; i++) {
            int n = lo + i;
            while (n != 1) {
                powers[i]++;
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n = 3 * n + 1;
                }
            }
        }
        int[] sorted = new int[hi - lo + 1];
        for (int i = 0; i < sorted.length; i++) {
            sorted[i] = lo + i;
        }
        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted.length - i - 1; j++) {
                if (powers[j] > powers[j + 1]) {
                    int temp = powers[j];
                    powers[j] = powers[j + 1];
                    powers[j + 1] = temp;
                    temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                } else if (powers[j] == powers[j + 1]) {
                    if (sorted[j] > sorted[j + 1]) {
                        int temp = sorted[j];
                        sorted[j] = sorted[j + 1];
                        sorted[j + 1] = temp;
                    }
                }
            }
        }
        return sorted[k - 1];
    }
}
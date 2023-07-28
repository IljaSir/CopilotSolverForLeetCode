class Solution {
    public int getKth(int lo, int hi, int k) {
        
        int[] power = new int[hi + 1];
        for (int i = lo; i <= hi; i++) {
            power[i] = getPower(i, power);
        }
        int[] sorted = Arrays.copyOfRange(power, lo, hi + 1);
        Arrays.sort(sorted);
        for (int i = lo; i <= hi; i++) {
            if (power[i] == sorted[k - 1]) {
                return i;
            }
        }
        return -1;
    }
    private int getPower(int num, int[] power) {
        if (num == 1) {
            return 0;
        }
        if (num % 2 == 0) {
            return power[num / 2] + 1;
        } else {
            return power[3 * num + 1] + 1;
        }
    }
}
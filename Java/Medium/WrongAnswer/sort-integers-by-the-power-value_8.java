class Solution {
    public int getKth(int lo, int hi, int k) {
        
        int[] powers = new int[hi - lo + 1];
        for (int i = lo; i <= hi; i++) {
            powers[i - lo] = power(i);
        }

        int[] sorted = powers.clone();
        Arrays.sort(sorted);

        int target = sorted[k - 1];
        for (int i = 0; i < powers.length; i++) {
            if (powers[i] == target) {
                return i + lo;
            }
        }

        return 0;
    }

    private int power(int x) {
        int power = 0;
        while (x != 1) {
            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = 3 * x + 1;
            }
            power++;
        }
        return power;
    }
}
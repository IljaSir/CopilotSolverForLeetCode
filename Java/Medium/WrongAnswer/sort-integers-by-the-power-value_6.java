class Solution {
    public int getKth(int lo, int hi, int k) {
        
        int[] powers = new int[hi - lo + 1];
        for (int i = lo; i <= hi; i++) {
            powers[i - lo] = getPower(i);
        }
        int[] sortedPowers = Arrays.copyOf(powers, powers.length);
        Arrays.sort(sortedPowers);
        int power = sortedPowers[k - 1];
        for (int i = 0; i < powers.length; i++) {
            if (powers[i] == power) {
                return i + lo;
            }
        }
        return 0;
    }

    private int getPower(int n) {
        int power = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            power++;
        }
        return power;
    }
}
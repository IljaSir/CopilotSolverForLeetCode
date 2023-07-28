class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(spells);
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int l = 0, r = potions.length - 1, j = potions.length;
            while (l <= r) {
                int m = l + (r - l) / 2;
                if (spells[i] * potions[m] >= success) {
                    j = m;
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            res[i] = potions.length - j;
        }
        return res;
    }
}
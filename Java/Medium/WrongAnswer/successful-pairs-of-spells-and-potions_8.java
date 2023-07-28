class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int l = 0, r = potions.length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (spells[i] * potions[m] < success) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            result[i] = potions.length - l;
        }
        return result;
    }
}
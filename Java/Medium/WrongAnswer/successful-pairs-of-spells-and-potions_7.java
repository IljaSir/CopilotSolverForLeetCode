class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(spells);
        Arrays.sort(potions);
        int[] ret = new int[spells.length];
        int i = 0, j = potions.length - 1;
        for (int k = 0; k < spells.length; k++) {
            while (i < potions.length && spells[k] * potions[i] < success) {
                i++;
            }
            ret[k] = potions.length - i;
        }
        return ret;
    }
}
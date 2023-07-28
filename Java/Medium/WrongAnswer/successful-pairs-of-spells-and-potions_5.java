class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int[] result = new int[spells.length];
        Arrays.sort(spells);
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            for (int j = potions.length - 1; j >= 0; j--) {
                if ((long) spells[i] * potions[j] >= success) {
                    result[i] += j + 1;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
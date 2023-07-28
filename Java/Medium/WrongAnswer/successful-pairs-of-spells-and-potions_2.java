class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(spells);
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            for (int j = potions.length - 1; j >= 0; j--) {
                if (spells[i] * potions[j] < success) {
                    break;
                } else {
                    result[i] += j + 1;
                }
            }
        }
        return result;
    }
}
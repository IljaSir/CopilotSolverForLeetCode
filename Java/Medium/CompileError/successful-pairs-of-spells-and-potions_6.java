class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            result[i] = (int) Arrays.stream(potions).filter(potion -> potion * spells[i] >= success).count();
        }
        return result;
    }
}
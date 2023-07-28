class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(spells);
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        int j = potions.length - 1;
        for (int i = 0; i < spells.length; i++) {
            while (j >= 0 && (long) spells[i] * potions[j] >= success) {
                j--;
            }
            ans[i] = j + 1;
        }
        return ans;
    }
}
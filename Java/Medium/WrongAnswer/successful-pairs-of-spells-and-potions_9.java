class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int cnt = 0;
            int left = 0;
            int right = potions.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (spells[i] * potions[mid] >= success) {
                    cnt = potions.length - mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = cnt;
        }
        return result;
    }
}
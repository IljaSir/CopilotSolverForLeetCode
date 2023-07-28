class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(spells);
        Arrays.sort(potions);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int l = 0;
            int r = m - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (spells[i] * potions[mid] < success) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            res[i] = l;
        }
        return res;
    }
}
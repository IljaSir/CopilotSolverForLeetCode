class Solution {
    public int totalFruit(int[] fruits) {
        
        int max = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        while (j < fruits.length) {
            if (fruits[j] == fruits[i]) {
                j++;
                continue;
            }
            if (k == 0) {
                k = fruits[j];
                j++;
                continue;
            }
            if (fruits[j] == k) {
                j++;
                continue;
            }
            max = Math.max(max, j - i);
            i = j - 1;
            while (i >= 0 && fruits[i] == fruits[i - 1]) {
                i--;
            }
            k = 0;
        }
        return Math.max(max, j - i);
    }
}
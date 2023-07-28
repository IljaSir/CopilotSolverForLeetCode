class Solution {
    public int totalFruit(int[] fruits) {
        
        int n = fruits.length;
        int max = 0;
        int i = 0;
        int j = 0;
        int first = -1;
        int second = -1;
        while (j < n) {
            if (fruits[j] == first || fruits[j] == second) {
                j++;
            } else if (first == -1) {
                first = fruits[j];
                j++;
            } else if (second == -1) {
                second = fruits[j];
                j++;
            } else {
                max = Math.max(max, j - i);
                first = fruits[j - 1];
                second = fruits[j];
                i = j - 1;
                while (i >= 0 && fruits[i] == first) {
                    i--;
                }
                i++;
            }
        }
        return Math.max(max, j - i);
    }
}
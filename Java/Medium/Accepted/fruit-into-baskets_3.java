class Solution {
    public int totalFruit(int[] fruits) {
        
        int max = 0;
        int start = 0;
        int end = 0;
        int first = -1;
        int second = -1;
        while (end < fruits.length) {
            if (fruits[end] == first || fruits[end] == second) {
                end++;
            } else if (first == -1) {
                first = fruits[end];
                end++;
            } else if (second == -1) {
                second = fruits[end];
                end++;
            } else {
                max = Math.max(max, end - start);
                start = end - 1;
                while (start > 0 && fruits[start] == fruits[start - 1]) {
                    start--;
                }
                first = fruits[start];
                second = fruits[end];
                end++;
            }
        }
        max = Math.max(max, end - start);
        return max;
    }
}
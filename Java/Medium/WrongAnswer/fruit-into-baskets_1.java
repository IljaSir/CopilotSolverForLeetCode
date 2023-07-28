class Solution {
    public int totalFruit(int[] fruits) {
        
        int n = fruits.length;
        int[] count = new int[n];
        int res = 0;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (count[fruits[j]]++ == 0) {
                i++;
            }
            while (i > 2) {
                if (--count[fruits[j - i + 1]] == 0) {
                    i--;
                }
            }
            res = Math.max(res, j - i + 2);
        }
        return res;
    }
}
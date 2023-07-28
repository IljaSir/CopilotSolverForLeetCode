class Solution {
    public int totalFruit(int[] fruits) {
        
        int n = fruits.length;
        if (n <= 2) return n;
        int[] count = new int[n];
        int res = 0, i = 0;
        for (int j = 0; j < n; j++) {
            count[fruits[j]]++;
            while (i < j && count[fruits[i]] == 0) {
                count[fruits[i]]--;
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
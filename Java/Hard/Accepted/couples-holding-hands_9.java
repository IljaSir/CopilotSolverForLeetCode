class Solution {
    public int minSwapsCouples(int[] row) {
        
        int len = row.length;
        int[] pos = new int[len];
        for (int i = 0; i < len; i++) {
            pos[row[i]] = i;
        }
        int res = 0;
        for (int i = 0; i < len; i += 2) {
            int x = row[i];
            int y = x ^ 1;
            if (row[i + 1] == y) {
                continue;
            }
            res++;
            int j = pos[y];
            row[j] = row[i + 1];
            pos[row[i + 1]] = j;
        }
        return res;
    }
}
class Solution {
    public int minSwapsCouples(int[] row) {
        
        int[] pos = new int[row.length];
        for (int i = 0; i < row.length; i++) {
            pos[row[i]] = i;
        }
        int count = 0;
        for (int i = 0; i < row.length; i += 2) {
            int x = row[i];
            int y = x % 2 == 1 ? x - 1 : x + 1;
            if (row[i + 1] == y) {
                continue;
            }
            count++;
            int j = pos[y];
            row[j] = row[i + 1];
            pos[row[i + 1]] = j;
        }
        return count;
    }
}
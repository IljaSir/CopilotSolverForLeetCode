class Solution {
    public int minSwapsCouples(int[] row) {
        
        int n = row.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; ++i) {
            pos[row[i]] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; i += 2) {
            int x = row[i];
            int y = x ^ 1;
            if (row[i + 1] == y) {
                continue;
            }
            ++ans;
            int j = pos[y];
            row[j] = row[i + 1];
            pos[row[i + 1]] = j;
        }
        return ans;
    }
}
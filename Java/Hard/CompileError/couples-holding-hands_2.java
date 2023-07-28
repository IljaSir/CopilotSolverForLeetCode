class Solution {
    public int minSwapsCouples(int[] row) {
        
        int n = row.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[row[i]] = i;
        }
        int ans = 0;
        for (int i = 0; i < n; i += 2) {
            int x = row[i];
            if (x % 2 == 0) {
                if (row[i + 1] == x + 1) {
                    continue;
                }
                int y = x + 1;
                int posy = pos[y];
                swap(row, i + 1, posy);
                pos[x + 1] = i + 1;
                pos[row[i + 1]] = posy;
                ans++;
            } else {
                if (row[i + 1] == x - 1) {
                    continue;
                }
                int y = x - 1;
                int posy = pos[y];
                swap(row, i + 1, posy);
                pos[x - 1] = i + 1;
                pos[row[i + 1]] = posy;
                ans++;
            }
        }
        return ans;
    }
}
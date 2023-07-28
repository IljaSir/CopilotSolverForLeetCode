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
                if (row[i + 1] != x + 1) {
                    ans++;
                    int t = row[i + 1];
                    row[i + 1] = x + 1;
                    row[pos[x + 1]] = t;
                    pos[t] = pos[x + 1];
                }
            } else {
                if (row[i + 1] != x - 1) {
                    ans++;
                    int t = row[i + 1];
                    row[i + 1] = x - 1;
                    row[pos[x - 1]] = t;
                    pos[t] = pos[x - 1];
                }
            }
        }
        return ans;
    }
}